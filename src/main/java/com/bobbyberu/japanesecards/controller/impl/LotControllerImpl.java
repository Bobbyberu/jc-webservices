package com.bobbyberu.japanesecards.controller.impl;

import com.bobbyberu.japanesecards.controller.LotController;
import com.bobbyberu.japanesecards.dto.LotReduced;
import com.bobbyberu.japanesecards.models.Lot;
import com.bobbyberu.japanesecards.repository.LotRepository;
import com.bobbyberu.japanesecards.service.LotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class LotControllerImpl implements LotController {

    private LotRepository lotRepository;

    private LotService lotService;

    public LotControllerImpl(LotRepository lotRepository, LotService lotService) {
        this.lotRepository = lotRepository;
        this.lotService = lotService;
    }

    @Override
    public Lot getLastLot() {
        return lotService.getLatestLot();
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
