package com.example.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.Bank.Repo.LoanRepo;
import com.example.Bank.Repo.UserRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepo.class,LoanRepo.class})
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
