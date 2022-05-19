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
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "userId")
public class Benefactor extends User{
	@ManyToMany
	private Set<Beneficiary> beneficiary;
}
