package com.bobbyberu.japanesecards.repository;

import com.bobbyberu.japanesecards.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
}
