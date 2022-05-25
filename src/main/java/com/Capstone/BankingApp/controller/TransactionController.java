/**
 * 
 */
package com.Capstone.BankingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.service.TransactionsService;

/**
 * @author Dekun
 * @Date 23 May 2022	
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionsService ts;
	
	@PutMapping(value = "/transfer/{fromCardNo}/{toCardNo}/{amount}/{reference}")
	public String Transfer(@PathVariable("fromCardNo") long fromCardNo,@PathVariable("toCardNo") long toCardNo, @PathVariable("amount") double amount, @PathVariable("reference")String reference) {
		return ts.Transfer(fromCardNo, toCardNo, amount, reference);
	}
	
	

}
