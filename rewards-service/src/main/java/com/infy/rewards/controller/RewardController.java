package com.infy.rewards.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.rewards.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

	@Autowired
	private RewardService rewardService;

	@GetMapping("/{customerId}/{monthAgo}/total")
	public ResponseEntity<Integer> getRewardsNMonthsAgo(@PathVariable Long customerId, @PathVariable Integer monthAgo) {
		return new ResponseEntity<>(rewardService.getRewardsNMonthsAgo(customerId, monthAgo), HttpStatus.OK);

	}

}
