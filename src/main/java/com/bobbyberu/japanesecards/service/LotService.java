package com.bobbyberu.japanesecards.service;

import com.bobbyberu.japanesecards.models.Lot;

public interface LotService {
    Lot getLatestLot();

    Lot createLot(Lot l);
}
