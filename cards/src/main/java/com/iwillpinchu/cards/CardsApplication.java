package com.iwillpinchu.cards;

import com.iwillpinchu.cards.dto.BuildInfoDto;
import com.iwillpinchu.cards.dto.CardsContactInfoDto;
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
@EnableConfigurationProperties({CardsContactInfoDto.class,
		BuildInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards Documentation",
				description = "Cards Microservices REST API documentation",
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
@EnableDiscoveryClient
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
