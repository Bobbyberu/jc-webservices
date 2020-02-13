package com.bobbyberu.japanesecards.dto;

import com.bobbyberu.japanesecards.models.Lot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class LotReduced {
    private int id;

    private String name;

    private Instant creationDate;

    public LotReduced(Lot lot) {
        this.id = lot.getId();
        this.name = lot.getName();
        this.creationDate = lot.getCreationDate();
    }
}
