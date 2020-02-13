package com.bobbyberu.japanesecards.controller.impl;

import com.bobbyberu.japanesecards.controller.LotController;
import com.bobbyberu.japanesecards.dto.LotReduced;
import com.bobbyberu.japanesecards.models.Lot;
import com.bobbyberu.japanesecards.repository.CardRepository;
import com.bobbyberu.japanesecards.repository.LotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class LotControllerImpl implements LotController {
    @Inject
    private LotRepository lotRepository;

    @Inject
    private CardRepository cardRepository;

    @Override
    public Lot getLastLot() {
        return lotRepository.findFirstByOrderByCreationDateDesc();
    }

    @Override
    public Lot getLotById(int id) {
        Optional<Lot> queryResult = lotRepository.findById(id);

        if (queryResult.isPresent()) {
            return queryResult.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lot at given id was not found!");
        }
    }

    @Override
    public List<LotReduced> getLotList() {
        Iterable<Lot> lots = lotRepository.findAllByOrderByCreationDateDesc();

        return StreamSupport.stream(lots.spliterator(), false)
                .map(LotReduced::new)
                .collect(Collectors.toList());
    }

    @Override
    public Lot createLot(Lot lot) {
        return lotRepository.save(lot);
    }
}
