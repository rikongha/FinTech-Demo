package com.decagon.fintech_demo.controllers;

import com.decagon.fintech_demo.pojo.CardMessage;
import com.decagon.fintech_demo.pojo.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decagon.fintech_demo.entities.Card;
import com.decagon.fintech_demo.entities.Hit;
import com.decagon.fintech_demo.services.CardService;
import com.decagon.fintech_demo.services.HitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "card-scheme")
public class CardController {
	
	@Autowired
	private CardService cardService;

	@Autowired
	private HitService hitService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/verify/{accountNumber}")
	public GenericResponse veryCard(@PathVariable String accountNumber) {

		Card card = null;
		CardMessage message = new CardMessage();

		try {
			card = cardService.getCardDetails(accountNumber);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doCardJob(card,message, accountNumber);

		return new GenericResponse(card != null, message);

	}

	void doCardJob(Card card, CardMessage message, String cardNumber) {
		
		if (card != null) {

			Hit hit = hitService.findByCardNumber(cardNumber).orElse(null);

			if (hit != null) {
				// if its valid increase count
				if (card.isHasData())
					hit.setCount(hit.getCount() + 1);

			} else {

				hit = new Hit();
				hit.setCardNumber(cardNumber);
				// if its valid increase count
				if (card.isHasData())
					hit.setCount(1);
			}

			hitService.save(hit);

		}

	}

}// class
