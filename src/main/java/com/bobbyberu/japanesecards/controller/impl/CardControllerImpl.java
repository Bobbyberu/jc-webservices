package com.bobbyberu.japanesecards.controller.impl;

import com.bobbyberu.japanesecards.controller.CardController;
import com.bobbyberu.japanesecards.models.Card;
import com.bobbyberu.japanesecards.models.Lot;
import com.bobbyberu.japanesecards.repository.CardRepository;
import com.bobbyberu.japanesecards.repository.LotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CardControllerImpl implements CardController {

    private CardRepository cardRepository;

    private LotRepository lotRepository;

    public CardControllerImpl(CardRepository cardRepository, LotRepository lotRepository) {
        this.cardRepository = cardRepository;
        this.lotRepository = lotRepository;
    }

    @Override
    public Card getById(int id) {
        Optional<Card> queryResult = cardRepository.findById(id);

        if (queryResult.isPresent()) {
            return queryResult.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No card was found");
        }
    }

    @Override
    public List<Card> getGlobalLot() {
        Iterable<Card> queryResult = cardRepository.findAll();
        List<Card> cards = new ArrayList<>();
        queryResult.forEach(cards::add);

        if (cards.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No card was found");
        } else {
            return cards;
        }
    }

    @Override
    public Lot addToLot(int id, Card card) {
        Lot lot;
        Optional<Lot> queryResult = lotRepository.findById(id);
        if (queryResult.isPresent()) {
            lot = queryResult.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No lot was found");
        }

        lot.getCards().add(card.removeWhitespaces());
        return lotRepository.save(lot);
    }
}
