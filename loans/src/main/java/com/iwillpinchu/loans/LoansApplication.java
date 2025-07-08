package com.iwillpinchu.loans;

import com.iwillpinchu.loans.dto.BuildInfoDto;
import com.iwillpinchu.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing(
        auditorAwareRef = "auditAwareImpl"
)
@EnableConfigurationProperties({LoansContactInfoDto.class, BuildInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Documentation",
                description = "Accounts Microservices REST API documentation",
                version = "v1",
                contact = @Contact(
                        name = "Sanskar singhal",
                        email = "pinchusinghal6@gmail.com",
                        url = "https://github.com/IWillPinchU"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/IWillPinchU"
                )
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
