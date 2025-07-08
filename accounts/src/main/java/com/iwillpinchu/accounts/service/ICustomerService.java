package com.iwillpinchu.accounts.service;

import com.iwillpinchu.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String bigbankCorrelationId);
}
