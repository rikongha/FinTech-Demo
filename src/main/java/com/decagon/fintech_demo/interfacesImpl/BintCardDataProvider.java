package com.decagon.fintech_demo.interfacesImpl;

import com.decagon.fintech_demo.entities.CardScheme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.decagon.fintech_demo.interfaces.CardDataProvider;

public class BintCardDataProvider  implements CardDataProvider{

	
	@Override
	public ResponseEntity<String> verifyCard(String cardNumber) {
		return new ResponseEntity<>(CardScheme.detect(cardNumber).toString(), HttpStatus.OK);
	}



}
