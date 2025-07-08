package com.iwillpinchu.accounts.service.client;

import com.iwillpinchu.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String bigbankCorrelationId, String mobileNumber) {
        return null;
    }
}
