package com.infy.rewards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.infy.rewards.entity.Transaction;
import com.infy.rewards.repository.TransactionRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RewardService.class)
@WithMockUser
public class RewardServiceTest {
	@MockBean
	private TransactionRepository transactionRepository;
	@Autowired
	RewardService rewardService;

	@Test
	void getRewardsNMonthsAgo() throws Exception {

		LocalDate now = LocalDate.now();
		LocalDate threeMonthsAgo = now.minusMonths(3);
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
		Mockito.when(transactionRepository.findByCustomerIdAndDateBetween(1L, threeMonthsAgo, now))
				.thenReturn(transactions);
		int totalRewards = rewardService.getRewardsNMonthsAgo(1L, 3);
		assertEquals(365, totalRewards);
	}
}
