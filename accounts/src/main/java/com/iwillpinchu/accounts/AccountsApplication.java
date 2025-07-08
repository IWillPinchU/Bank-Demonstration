package com.iwillpinchu.accounts;

import com.iwillpinchu.accounts.dto.AccountsContactInfoDto;
import com.iwillpinchu.accounts.dto.BuildInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties({AccountsContactInfoDto.class,
BuildInfoDto.class})
@EnableFeignClients
@EnableDiscoveryClient
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
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
