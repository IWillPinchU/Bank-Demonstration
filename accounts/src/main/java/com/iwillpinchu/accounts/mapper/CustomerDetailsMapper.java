package com.iwillpinchu.accounts.mapper;

import com.iwillpinchu.accounts.dto.CustomerDetailsDto;
import com.iwillpinchu.accounts.entity.Customer;

public class CustomerDetailsMapper {
    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customer, CustomerDetailsDto customerDetailsDto) {
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }
}
