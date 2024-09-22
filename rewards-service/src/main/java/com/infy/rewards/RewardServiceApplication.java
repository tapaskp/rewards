package com.infy.rewards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class RewardServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(RewardServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RewardServiceApplication.class, args);
	}

}