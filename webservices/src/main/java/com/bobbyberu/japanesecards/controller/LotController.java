package com.bobbyberu.japanesecards.controller;

import com.bobbyberu.japanesecards.dto.LotReduced;
import com.bobbyberu.japanesecards.models.Lot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/lot")
public interface LotController {

    /**
     * Get the lot with the latest creation date
     *
     * @return latest created lot
     */
    @GetMapping(value = "/last", produces = "application/json")
    Lot getLastLot();

    /**
     * Get Lot at given id
     *
     * @param id the id of wanted Lot
     * @return the found Lot
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    Lot getLotById(@PathVariable int id);

    /**
     * get lot list without embedded card list
     *
     * @return the reduced lot list
     */
    @GetMapping(produces = "application/json")
    List<LotReduced> getLotList();

    /**
     * Create one new lot
     *
     * @param lot wanted to be created
     * @return the created lot
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    Lot createLot(@RequestBody Lot lot);
}
