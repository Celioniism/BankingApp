/**
 * 
 */
package com.Capstone.BankingApp.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Dekun
 * @Date 19 May 2022	
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "userId")
public class Beneficiary extends User {
	@ManyToMany
	private Set<Benefactor> benefactors;
	
}
