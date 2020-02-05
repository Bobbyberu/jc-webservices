package com.bobbyberu.japanesecards.repository;

import com.bobbyberu.japanesecards.models.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
}
