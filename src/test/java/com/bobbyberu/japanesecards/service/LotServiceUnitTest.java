package com.bobbyberu.japanesecards.service;

import com.bobbyberu.japanesecards.models.Lot;
import com.bobbyberu.japanesecards.repository.LotRepository;
import com.bobbyberu.japanesecards.service.impl.LotServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LotServiceUnitTest {

    @InjectMocks
    private LotServiceImpl lotService;

    @Mock
    private LotRepository lotRepository;

    private Lot lot;

    @BeforeEach
    public void init() {
        lot = new Lot();
    }

    @Test
    public void shouldReturnLatestCreatedLot() {
        // Given
        when(lotRepository.findFirstByOrderByCreationDateDesc()).thenReturn(lot);

        // Then
        Assertions.assertEquals(lotService.getLatestLot(), lot);
    }

    @Test
    public void shouldCreateLot() {
        // Given
        when(lotRepository.save(lot)).thenReturn(lot);

        // Then
        Assertions.assertEquals(lotService.createLot(lot), lot);
    }
}
