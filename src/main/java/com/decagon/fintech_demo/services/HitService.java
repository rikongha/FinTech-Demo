package com.decagon.fintech_demo.services;


import java.util.Optional;

import com.decagon.fintech_demo.entities.Hit;
import com.decagon.fintech_demo.repositories.HitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HitService {
	
	private HitRepository hitRepository;


	public HitService(HitRepository hitRepository) {
		this.hitRepository = hitRepository;
	}

	public Page<Hit> findAll(Pageable pageable) {
		return hitRepository.findAll(pageable);
	}
	
	public Optional<Hit> findByCardNumber(String cardNumber) {
		return hitRepository.findByCardNumber(cardNumber);
	}
	
	public Hit save(Hit hit) {

		return hitRepository.save(hit);
		
	}

	public Hit update(Hit hit) {

		return hitRepository.save(hit);
		
	}


}
