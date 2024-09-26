package com.infy.rewards.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.infy.rewards.exception.UserNotFoundException;
import com.infy.rewards.repository.TransactionRepository;
import com.infy.rewards.util.TestUtil;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RewardService.class)
@WithMockUser
public class RewardServiceTest {
	@MockBean
	private TransactionRepository transactionRepository;
	@Autowired
	RewardService rewardService;

	@Test
	void getRewardsNMonthsAgoTest() throws Exception {

		LocalDate now = LocalDate.now();
		LocalDate threeMonthsAgo = now.minusMonths(3);

		Mockito.when(transactionRepository.findByCustomerIdAndDateBetween(1L, threeMonthsAgo, now))
				.thenReturn(TestUtil.buildTransaction());
		int totalRewards = rewardService.getRewardsNMonthsAgo(1L, 3);
		assertEquals(365, totalRewards);
	}

	@Test
	void getRewardsNMonthsAgoTest_User_Not_Found() {

		LocalDate now = LocalDate.now();
		LocalDate threeMonthsAgo = now.minusMonths(3);

		Mockito.when(transactionRepository.findByCustomerIdAndDateBetween(1L, threeMonthsAgo, now))
				.thenReturn(new ArrayList<>());

		Throwable throwable = assertThrows(Throwable.class, () -> {
			rewardService.getRewardsNMonthsAgo(1L, 3);
		});
		assertEquals(UserNotFoundException.class, throwable.getClass());
	}
}
