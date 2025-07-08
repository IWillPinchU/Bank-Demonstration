package com.iwillpinchu.loans.service;

import com.iwillpinchu.loans.dto.LoansDto;

public interface ILoansService {
    public void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);
}
