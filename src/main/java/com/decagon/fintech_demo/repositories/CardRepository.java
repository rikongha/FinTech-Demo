package com.decagon.fintech_demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.decagon.fintech_demo.entities.Card;

public interface CardRepository extends CrudRepository<Card,Long>{

	Optional<Card> findByNumber(String number);
}
