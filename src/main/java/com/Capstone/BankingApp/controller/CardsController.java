/**
 * 
 */
package com.Capstone.BankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.service.CardsService;

/**
 * @author Dekun
 * @Date 23 May 2022
 *
 */
@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/cards")
public class CardsController {
	@Autowired
	CardsService cardservice;

	@GetMapping(value = "/showAllCards")
	public List<Cards> showAllCards() {
		return cardservice.showAllCards();
	}

	@PostMapping(value = "/registerCard")
	public void registertCard(@RequestBody Cards card) {
		cardservice.registerCard(card);
	}

	@DeleteMapping(value = "/deleteCard/{cardnumber}")
	public void deleteCard(@PathVariable("cardnumber") long cardnumber) {
		cardservice.deleteCard(cardnumber);
	}

	@PostMapping({ "/generateNewCard/{userId}" })
	public String generateNewCard(@PathVariable("userId") int userId, @RequestBody String Type) {
		cardservice.generateCard(userId, Type);
		return "added successfuly!";
	}

	@GetMapping({ "/showUserCardDetails/{userId}" })
	public List<Cards> showUserCardDetails(@PathVariable("associatedId") int associatedId) {
		List<Cards> cards = cardservice.showUserCardDetails(associatedId);
		return cards;
	}

}
