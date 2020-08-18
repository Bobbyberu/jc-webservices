package com.bobbyberu.japanesecards.service;

import com.bobbyberu.japanesecards.models.Card;
import com.bobbyberu.japanesecards.repository.CardRepository;
import com.bobbyberu.japanesecards.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceUnitTest {

    @InjectMocks
    CardServiceImpl cardService;

    @Mock
    CardRepository cardRepository;

    private Card card;

    @BeforeEach
    public void init() {
        card = new Card();
    }

    @Test
    public void shouldCreateCard(){
        // When
        when(cardRepository.save(card)).thenReturn(card);

        // Then
        Assertions.assertEquals(cardService.createCard(card), card);
    }
}
