package com.iwillpinchu.loans.mapper;

import com.iwillpinchu.loans.dto.LoansDto;
import com.iwillpinchu.loans.entity.Loans;

public class LoansMapper {

    public static Loans mapToLoans(LoansDto loansDto, Loans loans){
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto){
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }
}
