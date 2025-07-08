package com.iwillpinchu.cards.service;

import com.iwillpinchu.cards.dto.CardsDto;

public interface ICardsService {

    void createCard(String mobileNumber);
    CardsDto fetchCard(String mobileNumber);
    boolean updateCard(CardsDto cardsDto);
    boolean deleteCard(String mobileNumber);

}
