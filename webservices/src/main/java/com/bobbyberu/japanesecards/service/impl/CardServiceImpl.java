package com.bobbyberu.japanesecards.service.impl;

import com.bobbyberu.japanesecards.models.Card;
import com.bobbyberu.japanesecards.repository.CardRepository;
import com.bobbyberu.japanesecards.service.CardService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CardServiceImpl implements CardService {
    @Inject
    private CardRepository cardRepository;

    @Override
    public Card createCard(Card c) {
        return cardRepository.save(c);
    }
}
