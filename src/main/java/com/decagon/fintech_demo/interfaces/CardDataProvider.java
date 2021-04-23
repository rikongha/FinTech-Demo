package com.decagon.fintech_demo.interfaces;

import org.springframework.http.ResponseEntity;

public interface CardDataProvider {

	public ResponseEntity<String> verifyCard(String cardNumber);
	
}
