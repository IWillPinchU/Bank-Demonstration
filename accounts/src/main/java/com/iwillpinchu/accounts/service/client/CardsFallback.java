package com.iwillpinchu.accounts.service.client;

import com.iwillpinchu.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardsDto> fetchCardsDetails(String bigbankCorrelationId, String mobileNumber) {
        return null;
    }
}
