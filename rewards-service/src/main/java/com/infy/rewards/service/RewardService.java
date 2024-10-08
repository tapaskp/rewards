package com.infy.rewards.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.rewards.entity.Transaction;
import com.infy.rewards.exception.UserNotFoundException;
import com.infy.rewards.repository.TransactionRepository;
import com.infy.rewards.util.RewardConstant;

@Service
public class RewardService {
	@Autowired
	TransactionRepository transactionRepository;

	public int getRewardsNMonthsAgo(Long customerId, Integer monthAgo) {
		LocalDate now = LocalDate.now();
		LocalDate threeMonthsAgo = now.minusMonths(monthAgo);
		List<Transaction> transactions = transactionRepository.findByCustomerIdAndDateBetween(customerId,
				threeMonthsAgo, now);
		if (transactions.isEmpty()) {
			throw new UserNotFoundException(RewardConstant.USER_NOT_FOUND);
		}
		return transactions.stream().mapToInt(this::calculatePoints).sum();
	}

	private int calculatePoints(Transaction transaction) {
		double amount = transaction.getAmount();
		int points = 0;
		if (amount > 100) {
			points += (amount - 100) * 2;
			amount = 100;
		}
		if (amount > 50) {
			points += (amount - 50);
		}
		return points;
	}
}
