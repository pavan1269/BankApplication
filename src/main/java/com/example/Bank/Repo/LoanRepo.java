package com.example.Bank.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bank.Entity.Loan;
@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
