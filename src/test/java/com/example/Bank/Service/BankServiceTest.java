package com.example.Bank.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.Bank.Dao.Usersgt5L;
import com.example.Bank.Entity.Loan;
import com.example.Bank.Entity.User;
import com.example.Bank.Repo.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BankServiceTest {
	
	@Autowired
	BankService bankService;
	
	@Mock
	UserRepo userRepo;

	@Test
	void testRegisterService() {

		User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
		Loan loan=new Loan(1,"home",230000,3,2);
		user.setLoans(Arrays.asList(loan));
		when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
		User testUser=bankService.registerService(user);
		assertEquals(testUser.getName(), "pavan");
	}

	@Test
	void testUpdateContactService() {
		User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
		Loan loan=new Loan(1,"home",230000,3,2);
		user.setLoans(Arrays.asList(loan));
		when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
		User testUser=bankService.updateContactService(1,(long)1234);
		assertEquals(testUser.getContact(),1234);
	}

//	@Test
//	void testApplyLoanService() {
//		User user=new User(2,"pavan","pavan","pavan",(long) 1234,null,null);
//		Loan loan=new Loan(2,"home",230000,3,2);
//		user.setLoans(Arrays.asList(loan));
//		when(userRepo.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(user));
////		BankRequest bankRequest=new BankRequest();
////		bankRequest.setUser(user);
//		when(userRepo.save(Mockito.any(User.class))).thenReturn(user);
//		User testUser=bankService.applyLoanService(1,loan);
//		assertEquals(testUser.getLoans(),user.getLoans());
//	}

	@Test
	void testUsersService() {
		User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
		Loan loan=new Loan(1,"home",230000,3,2);
		user.setLoans(Arrays.asList(loan));
		List<User> users = new ArrayList<User>();
		users.add(user);
		when(userRepo.findAll()).thenReturn(users);
		List<User> users2=bankService.usersService();
		assertEquals(users.get(0).getName(), users2.get(0).getName());
	}

	@Test
	void testUsersgt5LService() {
		Usersgt5L usersgt5l=new Usersgt5L("pavan","home", 789000);
		List<Usersgt5L> usersgt5ls=new ArrayList<Usersgt5L>();
		usersgt5ls.add(usersgt5l);
		when(userRepo.usersLoanGt5L()).thenReturn(usersgt5ls);
		List<Usersgt5L> usersgt5ls2=bankService.usersgt5LService();
		assertEquals(usersgt5ls2.get(0).getAmount(),789000);
	}

}
