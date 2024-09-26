package com.infy.rewards.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.infy.rewards.entity.Transaction;
import com.infy.rewards.service.RewardService;

public class TransactionRepositoryTest {
	@Mock
	private TransactionRepository transactionRepository;
	@InjectMocks
	private RewardService rewardService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // init the mocks
	}

	@Test
	public void findByCustomerIdAndDateBetweenTest() {

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

		when(transactionRepository.findByCustomerIdAndDateBetween(1L, threeMonthsAgo, now)).thenReturn(transactions);

		int rewards = rewardService.getRewardsNMonthsAgo(1L, 3);

		assertEquals(365, rewards);
		verify(transactionRepository, times(1)).findByCustomerIdAndDateBetween(1L, threeMonthsAgo, now);
	}

}
