package com.iwillpinchu.accounts.service.impl;

import com.iwillpinchu.accounts.dto.AccountsDto;
import com.iwillpinchu.accounts.dto.CardsDto;
import com.iwillpinchu.accounts.dto.CustomerDetailsDto;
import com.iwillpinchu.accounts.dto.LoansDto;
import com.iwillpinchu.accounts.entity.Accounts;
import com.iwillpinchu.accounts.entity.Customer;
import com.iwillpinchu.accounts.exception.ResourceNotFoundException;
import com.iwillpinchu.accounts.mapper.AccountsMapper;
import com.iwillpinchu.accounts.mapper.CustomerDetailsMapper;
import com.iwillpinchu.accounts.repository.AccountsRepository;
import com.iwillpinchu.accounts.repository.CustomerRepository;
import com.iwillpinchu.accounts.service.ICustomerService;
import com.iwillpinchu.accounts.service.client.CardsFeignClient;
import com.iwillpinchu.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String bigbankCorrelationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "CustomerId", customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto = CustomerDetailsMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        AccountsDto accountsDto = AccountsMapper.mapToAccountsDto(accounts, new AccountsDto());
        customerDetailsDto.setAccountsDto(accountsDto);

        ResponseEntity<LoansDto> loansDtoResponseEntity =  loansFeignClient.fetchLoanDetails(bigbankCorrelationId, mobileNumber);
        if (loansDtoResponseEntity != null){
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardsDetails(bigbankCorrelationId, mobileNumber);
        if (cardsDtoResponseEntity != null){
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;
    }
}
