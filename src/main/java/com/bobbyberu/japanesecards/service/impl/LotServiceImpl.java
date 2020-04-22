package com.bobbyberu.japanesecards.service.impl;

import com.bobbyberu.japanesecards.models.Lot;
import com.bobbyberu.japanesecards.repository.LotRepository;
import com.bobbyberu.japanesecards.service.LotService;
import org.springframework.stereotype.Service;

@Service
public class LotServiceImpl implements LotService {

    private LotRepository lotRepository;

    private Lot lot;

    public LotServiceImpl(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    @Override
    public Lot getLatestLot() {
        return lotRepository.findFirstByOrderByCreationDateDesc();
    }

    @Override
    public Lot createLot(Lot l) {
        return lotRepository.save(l);
    }
}
