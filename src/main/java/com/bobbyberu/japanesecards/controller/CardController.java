package com.bobbyberu.japanesecards.controller;

import com.bobbyberu.japanesecards.models.Card;
import com.bobbyberu.japanesecards.models.Lot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/card")
public interface CardController {

    /**
     * get card at given id
     *
     * @param id of card
     * @return found card
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    Card getById(@PathVariable int id);

    /**
     * one unique lot with all cards created embedded
     *
     * @return unique lot
     */
    @GetMapping(value = "/all", produces = "application/json")
    List<Card> getGlobalLot();

    /**
     * Add card to given lot
     *
     * @param card
     * @return updated lot
     */
    @PostMapping(value = "/addtolot/{id}", consumes = "application/json", produces = "application/json")
    Lot addToLot(@PathVariable int id, @RequestBody Card card);
}
