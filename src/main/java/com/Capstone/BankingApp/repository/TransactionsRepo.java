/**
 * 
 */
package com.Capstone.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Capstone.BankingApp.entity.Transactions;

/**
 * @author Dekun
 * @Date 19 May 2022	
 *
 */
@Repository
public interface TransactionsRepo extends JpaRepository<Transactions, Long> {

}
