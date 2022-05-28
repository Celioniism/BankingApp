package com.Capstone.BankingApp.InputClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSD {
private String firstName;
private String lastName;
private String accessLevel;
private String username;
}
