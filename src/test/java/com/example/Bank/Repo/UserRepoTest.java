//package com.example.Bank.Repo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.example.Bank.Entity.Loan;
//import com.example.Bank.Entity.User;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@DataJpaTest
//public class UserRepoTest {
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Test
//	public void testSaveUser(){
//		User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
//		Loan loan=new Loan(1,"home",230000,3,2);
//		user.setLoans(Arrays.asList(loan));
//		User savedInDb = entityManager.persist(user);
//		Optional<User> getFromDb = userRepo.findById(savedInDb.getAccno());
//		
//		assertThat(getFromDb.get()).isEqualTo(savedInDb);
//	}
//}
