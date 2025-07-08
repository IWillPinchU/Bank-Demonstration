package com.iwillpinchu.accounts.service.client;

import com.iwillpinchu.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", url = "http://cards:9000", fallback = CardsFallback.class)
public interface CardsFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
     ResponseEntity<CardsDto> fetchCardsDetails(
            @RequestHeader("bigbank-correlation-id") String bigbankCorrelationId,
            @RequestParam String mobileNumber);
}
