package com.example.Bank.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Bank.Dao.Usersgt5L;
import com.example.Bank.Entity.User;

import java.util.*;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select new com.example.Bank.Dao.Usersgt5L(u.name,l.type,l.amount) from User u join u.loans l")
	public List<Usersgt5L> usersLoanGt5L();
	
	
	Optional<User> findByUsername(String username);

}
