package com.iwillpinchu.message.functions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.iwillpinchu.message.dto.AccountsMsgDto;

import java.util.function.Function;

@Configuration
@Slf4j
public class MessageFunctions {

    @Bean
    public Function<AccountsMsgDto, AccountsMsgDto> email(){
        return accountsMsgDto -> {
            log.info("Sending email with the details: {}", accountsMsgDto.toString());
            return accountsMsgDto;
        };
    }

    @Bean
    public Function<AccountsMsgDto, Long> sms(){
        return accountsMsgDto -> {
            log.info("Sending sms with the details: {}", accountsMsgDto.toString());
            return accountsMsgDto.accountNumber();
        };
    }

}
