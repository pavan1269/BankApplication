package com.example.Bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.Dao.BankRequest;
import com.example.Bank.Dao.Usersgt5L;
import com.example.Bank.Entity.Loan;
import com.example.Bank.Entity.User;
//import com.example.Bank.Repo.LoanRepo;
import org.springframework.http.MediaType;

import com.example.Bank.Service.BankService;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.*;

@RestController
public class BankController {
	
//	@Autowired
//	private UserRepo userRepo;
	
	@Autowired
	private BankService bankService;
	
	@PostMapping(path = "/newuser",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register(@RequestBody User user)
	{
		User user2=null;
		try {
		user2 =bankService.registerService(user);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Unable to Register"+e,HttpStatus.BAD_REQUEST);
			
		}
		 return new ResponseEntity<Object>(user,HttpStatus.OK);
	}
	
	@PutMapping("/update/{accno}/{contact}")
	public ResponseEntity<Object> updateUser(@PathVariable Long contact,@PathVariable int accno)
	{
//		Optional<User> usertoupdate=userRepo.findById(user.getAccno());
//		User u=usertoupdate.get();
//		u.setContact(user.getContact());
		//u.setName(user.getName());
		//u.setUsername(user.getUsername());
		//u.setPassword(user.getPassword());
		//return userRepo.save(u);
		User user=null;
		try {
			user=bankService.updateContactService(accno,contact);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>("Unable to update contact: "+e,HttpStatus.BAD_REQUEST);
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(user,HttpStatus.OK);
	}

	@PostMapping("/applyloan/{accno}")
	public ResponseEntity<Object> applyLoan(@PathVariable int accno,@RequestBody Loan loan)
	{
		//return userRepo.save(request.getUser());
		User user=null;
		try {
		user=bankService.applyLoanService(accno,loan);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Object>("Not able to process the request: "+e,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(user,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> Users()
	{
		//return userRepo.findAll();
		return new ResponseEntity<List<User>>(bankService.usersService(),HttpStatus.OK);
		//return bankService.usersService();
	}
	
	@GetMapping("/usersabovefiveL")
	public ResponseEntity<List<Usersgt5L>> Usersgt5L()
	{
		return new ResponseEntity<List<Usersgt5L>>(bankService.usersgt5LService(),HttpStatus.OK);
		
//		return bankService.usersgt5LService();
//		List<Usersgt5L> usersList= userRepo.usersLoanGt5L();//userRepo.usersLoanGt5L();
//		
//		return usersList.stream().filter(user->(user.getAmount()>500000)).collect(Collectors.toList());
//		
		//service layer,bean package,urls,method names, entities
	}
}
