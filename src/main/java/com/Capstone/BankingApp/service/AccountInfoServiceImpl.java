package com.Capstone.BankingApp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.BankingApp.InputClasses.UserSD;
import com.Capstone.BankingApp.InputClasses.UserStats;
import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.AccountInfoRepo;
import com.Capstone.BankingApp.repository.UserRepo;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

	@Autowired
	AccountInfoRepo accountInfoRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	TransactionsService TS;

	@Override
	public void editSecurityQuestion(long accountNo, AccountInfo accountInfo) {
		// get accountNo
		AccountInfo ai; // must be found and retrieved as an object to assign values and update <==
		ai = accountInfoRepo.findById(accountNo).get();
		// update securityQuestion and securityAnswer
		ai.setSecurityQuestion(accountInfo.getSecurityQuestion());
		ai.setSecurityAnswer(accountInfo.getSecurityAnswer()); // the newly found object can have properties changed <==
		// save updated securityQuestion
		accountInfoRepo.save(ai); // the object is passed and the database uses the new data to update tables<==
	}

	@Override
	public void editSecurityAnswer(long accountNo, AccountInfo accountInfo) {
		// get accountNo
		accountInfoRepo.findById(accountNo);
		// update securityAnswer
		accountInfo.setSecurityAnswer(accountInfo.getSecurityAnswer());
		;
		// save updated securityAnswer
		accountInfoRepo.save(accountInfo);
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		User temp = userRepo.findByUserName(userName);
		if (temp.getUserName() == userName && temp.getPassword() == password)
			return true;
		else
			return false;
	}

	@Override
	public List<AccountInfo> getAllAccounts() {
		return accountInfoRepo.findAll();
	}

	@Override
	public void createAccount(AccountInfo accountInfo) {
		int lock = 0;
		int min = 000000;
		int max = 999999;
		int random1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		String random2 = String.valueOf(random1);
		long acnum = Long.parseLong(random2);
		while (lock == 0) {
			if (accountInfoRepo.findById(acnum) != null) {
				acnum += 1;
			} else {
				lock = 0;
				accountInfo.setAccountNumber(acnum);
			}
		}
		if (accountInfo.getSecurityQuestion() != null && accountInfo.getSecurityAnswer() != null
				&& accountInfo.getFistName() != null && accountInfo.getLastName() != null) {
			accountInfo.setAccessLevel("regular");
			accountInfoRepo.save(accountInfo);
			User u = userRepo.findById(accountInfo.getUserId()).get();
			if (u != null) {
				u.setAccountInfo(accountInfo);
				userRepo.save(u);
			}
		} else
			System.out.println("error creating user, null fields exist");
	}

	@Override
	public AccountInfo registerFactory(AccountInfo accountInfo) {
		int lock = 0;
		int min = 000000;
		int max = 999999;
		AccountInfo AI = accountInfo;
		int random1 = (int) Math.floor(Math.random() * (max - min + 1) + min);

		String random2 = String.valueOf(random1);
		long acnum = Long.parseLong(random2);

		while (lock == 0) {
			if (accountInfoRepo.existsById(acnum)) {
				acnum += 1;
			} else {
				lock = 1;

				AI.setAccountNumber(acnum);

			}
			acnum -= 3;
		}
		return AI;
	}

	@Override
	public List<UserStats> getStats(int userId) {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
		String CurrentDate = formatter.format(date);
		String[] datechanges = CurrentDate.split("/", 2);

		List<UserStats> us = new ArrayList<UserStats>();
		List<UserStats> us2 = new ArrayList<UserStats>();
		List<UserStats> us3 = new ArrayList<UserStats>();
		double moneyIn = 0, moneyOut = 0;
		List<Transactions> ut = new ArrayList<Transactions>();
		List<Integer> Deposits = new ArrayList<Integer>();
		List<Integer> Withdrawals = new ArrayList<Integer>();
		List<Integer> Transfers = new ArrayList<Integer>();
		List<Integer> epercents = new ArrayList<Integer>();
		List<Integer> dpercents = new ArrayList<Integer>();
		ut = TS.userTransactions(userId);

		for (Transactions t : ut) {
			if (t.getTransactionType().equalsIgnoreCase("deposit")) {
				String[] datec = t.getDate_and_time().split("/", 3);
				String datec1 = datec[1];
				String[] datec2;
				datec2 = datec[2].split(" ", 2);

				Deposits.add((int) (t.getAmount()));
				if (datec1.equals(datechanges[0]) && datec2[0].equals(datechanges[1])) {
					moneyIn += t.getAmount();
				}
			} else if (t.getTransactionType().equalsIgnoreCase("withdraw")) {
				String[] datec = t.getDate_and_time().split("/", 3);
				String datec1 = datec[1];
				String[] datec2;
				datec2 = datec[2].split(" ", 2);
				Withdrawals.add((int) (t.getAmount()));

				if (datec1.equals(datechanges[0]) && datec2[0].equals(datechanges[1])) {
					moneyOut += t.getAmount();
				}
			} else {
				Transfers.add((int) (t.getAmount()));
			}
		}
		Collections.sort(Deposits, Collections.reverseOrder());
		Collections.sort(Withdrawals);
		Collections.sort(Transfers, Collections.reverseOrder());

		if (Deposits.size() > 5) {
			Deposits.subList(5, Deposits.size()).clear();
		}
		if (Withdrawals.size() > 5) {
			Withdrawals.subList(5, Withdrawals.size()).clear();
		}
		if (!Deposits.isEmpty()) {
			double depoLargest = Deposits.get(0);
			for (Integer d : Deposits) {
				dpercents.add((int) (100 * (d / depoLargest)));
			}
		}
		if (!Withdrawals.isEmpty()) {
			double withdrawLargest = Withdrawals.get(0);
			for (Integer w : Withdrawals) {
				epercents.add((int) (100 * (Math.abs(w) / Math.abs(withdrawLargest))));
			}
		}

		int wsize = Withdrawals.size();
		int dsize = Deposits.size();

		for (int i = 0; i < dsize; i++) {
			UserStats stat = new UserStats();
			stat.setDeposits(Deposits.get(i));
			stat.setDpercents(dpercents.get(i));
			us.add(stat);
		}

		for (int i = 0; i < wsize; i++) {
			UserStats stat2 = new UserStats();
			stat2.setExpenses(Withdrawals.get(i));
			stat2.setEpercents(epercents.get(i));
			us2.add(stat2);
		}
		int j = 0;
		if (wsize > dsize) {
			for (UserStats st : us2) {
				UserStats n = new UserStats();
				if (j < dsize) {
					n.setDeposits(us.get(j).getDeposits());
					n.setDpercents(us.get(j).getDpercents());
					n.setEpercents(st.getEpercents());
					n.setExpenses(st.getExpenses());
					n.setMoneyIn(moneyIn);
					n.setMoneyOut(moneyOut);
					us3.add(n);
					j++;
				} else {
					n.setEpercents(st.getEpercents());
					n.setExpenses(st.getExpenses());
					n.setMoneyIn(moneyIn);
					n.setMoneyOut(moneyOut);
					us3.add(n);

				}

			}
		} else {
			for (UserStats st : us) {
				UserStats n = new UserStats();
				if (j < wsize) {
					n.setDeposits(st.getDeposits());
					n.setDpercents(st.getDpercents());
					n.setEpercents(us2.get(j).getEpercents());
					n.setExpenses(us2.get(j).getExpenses());
					n.setMoneyIn(moneyIn);
					n.setMoneyOut(moneyOut);
					j++;
					us3.add(n);
				} else {
					n.setDeposits(st.getDeposits());
					n.setDpercents(st.getDpercents());
					n.setMoneyIn(moneyIn);
					n.setMoneyOut(moneyOut);
					us3.add(n);
				}
			}
		}
		return us3;
	}

	@Override
	public UserSD returnUserdata(String username, String password) {
		User u = userRepo.findByUsernPw(username, password);
		AccountInfo ai = accountInfoRepo.findByUserId(u.getUserId());
		UserSD sd = new UserSD();
		sd.setAccessLevel(ai.getAccessLevel());
		sd.setFirstName(ai.getFistName());
		sd.setLastName(ai.getLastName());
		sd.setUsername(username);
		return sd;
	}

	public UserSD returnUserdataId(int userId) {
		User u = userRepo.findById(userId).get();
		AccountInfo ai = accountInfoRepo.findByUserId(u.getUserId());
		UserSD sd = new UserSD();
		sd.setAccessLevel(ai.getAccessLevel());
		sd.setFirstName(ai.getFistName());
		sd.setLastName(ai.getLastName());
		sd.setUsername(u.getUserName());
		return sd;
	}

	@Override
	public AccountInfo getAccountByAcctNo(long accountNo) {
		return accountInfoRepo.findById(accountNo).get();

	}
}