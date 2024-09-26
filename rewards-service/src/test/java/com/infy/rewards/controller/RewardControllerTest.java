package com.infy.rewards.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.infy.rewards.service.RewardService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RewardController.class)
@WithMockUser
public class RewardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RewardService rewardService;

	@Test
	void getRewardsNMonthsAgo() throws Exception {

		Mockito.when(rewardService.getRewardsNMonthsAgo(Mockito.anyLong(), Mockito.anyInt())).thenReturn(365);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/rewards/1/3/total")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());

		assertEquals("365", result.getResponse().getContentAsString());
	}
}