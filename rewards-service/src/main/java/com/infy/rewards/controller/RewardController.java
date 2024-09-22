package com.infy.rewards.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.rewards.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

	@Autowired
	private RewardService rewardService;

	@GetMapping("/{customerId}/{monthAgo}/total")
	public int getRewardsNMonthsAgo(@PathVariable Long customerId, @PathVariable Long monthAgo) {
		return rewardService.getRewardsNMonthsAgo(customerId, monthAgo);
	}
}
