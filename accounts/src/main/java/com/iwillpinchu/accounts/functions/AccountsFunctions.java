package com.iwillpinchu.accounts.functions;

import com.iwillpinchu.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
@AllArgsConstructor
public class AccountsFunctions {

    private final IAccountsService accountsService;

    @Bean
    public Consumer<Long> updateCommunication(){
        return accountNumber -> {
            log.info("Updating communication status for: {}", accountNumber);
            accountsService.updateCommunicationStatus(accountNumber);

        };
    }
}
