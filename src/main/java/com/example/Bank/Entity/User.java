package com.example.Bank.Entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accno;
    private String name;
    private String username;
    private String password;
    private Long contact;
    private String role;
    
    

	@OneToMany(targetEntity = Loan.class,cascade = CascadeType.ALL)
    @JoinColumn(name="accno",referencedColumnName = "accno")
    private List<Loan> loans;
    

	public User() {
		
	}

	public User(int accno, String name, String username, String password, Long contact,String role, List<Loan> loans) {
		this.accno = accno;
		this.name = name;
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.role=role;
		this.loans = loans;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
    
    
    
    
}
