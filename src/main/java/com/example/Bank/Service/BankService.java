package com.example.Bank.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.Dao.BankRequest;
import com.example.Bank.Dao.Usersgt5L;
import com.example.Bank.Entity.Loan;
import com.example.Bank.Entity.User;
import com.example.Bank.Repo.UserRepo;

@Service
public class BankService {

	@Autowired
	private UserRepo userRepo;
	
	public User registerService(User user)
	{
		return userRepo.save(user);
	}
	
	public User updateContactService(int accno,Long contact)
	{
		Optional<User> usertoupdate=userRepo.findById(accno);
		usertoupdate.orElseThrow(()->new NullPointerException("Account not found with Accno:"+accno));
		User u=usertoupdate.get();
		u.setContact(contact);
		//u.setName(user.getName());
		//u.setUsername(user.getUsername());
		//u.setPassword(user.getPassword());
		return userRepo.save(u);
	}
	
	public User applyLoanService(int accno,Loan loan)
	{
//		User user=request.getUser();
//		Optional<User> returnUser = null;
//		Map<String,String> userpwdsMap=new HashMap<String, String>();
//		userRepo.findAll().stream().forEach(users->{
//			userpwdsMap.put(users.getUsername(),users.getPassword());
//		});
//		if((userpwdsMap.keySet()).contains(user.getUsername()))
//		{
//			if(userpwdsMap.get(user.getUsername())==user.getPassword())
//			{
//				 returnUser=userRepo.findById(request.getUser().getAccno());
//				 returnUser.get().getLoans().addAll(user.getLoans());
//			}
//		}
		//User user=request.getUser();
		Optional<User> usertoupdate=userRepo.findById(accno);
		usertoupdate.orElseThrow(()->new NullPointerException("Account not found with Accno:"+accno));
		User user=usertoupdate.get();
		List<Loan> loansofuser=user.getLoans();
		loansofuser.add(loan);
		return userRepo.save(user);
	}
	
	
	public List<User> usersService()
	{
		return userRepo.findAll();
	}
	
	public List<Usersgt5L> usersgt5LService()
	{
		List<Usersgt5L> usersList= userRepo.usersLoanGt5L();//userRepo.usersLoanGt5L();
		
		return usersList.stream().filter(user->(user.getAmount()>500000)).collect(Collectors.toList());
		
		//service layer,bean package,urls,method names, entities
	}
}
