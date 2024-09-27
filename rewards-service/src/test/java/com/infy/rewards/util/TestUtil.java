package com.infy.rewards.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.infy.rewards.entity.Transaction;

public class TestUtil {
	public static List<Transaction> buildTransaction() {
		List<Transaction> transactions = new ArrayList<>();
		Transaction transaction1 = new Transaction();
		transaction1.setId(1L);
		transaction1.setCustomerId(1L);
		transaction1.setAmount(120D);
		transaction1.setDate(LocalDate.of(2024, 7, 15));

		Transaction transaction2 = new Transaction();
		transaction2.setId(2L);
		transaction2.setCustomerId(1L);
		transaction2.setAmount(75D);
		transaction2.setDate(LocalDate.of(2024, 8, 10));

		Transaction transaction3 = new Transaction();
		transaction3.setId(3L);
		transaction3.setCustomerId(1L);
		transaction3.setAmount(200D);
		transaction3.setDate(LocalDate.of(2024, 9, 5));
		
		transactions.add(transaction1);
		transactions.add(transaction2);
		transactions.add(transaction3);
		return transactions;
	}

}
