package com.bobbyberu.japanesecards.service;

import com.bobbyberu.japanesecards.models.Card;
import org.springframework.stereotype.Service;

public interface CardService {
    Card createCard(Card c);
}
