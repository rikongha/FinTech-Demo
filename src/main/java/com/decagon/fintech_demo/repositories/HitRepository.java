package com.decagon.fintech_demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.decagon.fintech_demo.entities.Hit;

public interface HitRepository extends PagingAndSortingRepository<Hit,Long>{

	Optional<Hit> findByCardNumber(String cardNumber);
}