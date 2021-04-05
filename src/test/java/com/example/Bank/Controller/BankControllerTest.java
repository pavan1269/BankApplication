package com.example.Bank.Controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.Bank.Dao.Usersgt5L;
import com.example.Bank.Entity.Loan;
import com.example.Bank.Entity.User;
import com.example.Bank.Service.BankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {

//	@Autowired
//	private WebApplicationContext wacApplicationContext;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	BankService bankService;
	
	@Before
	public void setUp() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(bankService).build();
		MockitoAnnotations.initMocks(this);
	}
//	private static ObjectMapper mapper=new ObjectMapper();
//	
@Test
void testRegister() throws Exception {
	User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
	
	String inputInJson = this.mapToJson(user);
	Mockito.when(bankService.registerService(Mockito.any(User.class))).thenReturn(user);
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/newuser")
			.accept(MediaType.APPLICATION_JSON).content(inputInJson)
			.contentType(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	MockHttpServletResponse response = result.getResponse();
	
	String outputInJson = response.getContentAsString();
	System.out.println(outputInJson);
	assertThat(outputInJson).isEqualTo(inputInJson);
	assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

@Test
void testUpdate() throws Exception {
	User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
	
	//String inputInJson = this.mapToJson(user);
	Mockito.when(bankService.updateContactService(Mockito.any(Integer.class),Mockito.any(Long.class))).thenReturn(user);
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.put("/update/1/1234")
			//.accept(MediaType.APPLICATION_JSON)//.content(inputInJson)
			.contentType(MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	MockHttpServletResponse response = result.getResponse();
	
	String outputInJson = response.getContentAsString();
	System.out.println(outputInJson);
	//assertThat(outputInJson).isEqualTo(inputInJson);
	assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

@Test
public void testUsers() throws Exception {
	User user=new User(1,"pavan","pavan","pavan",(long) 1234,null,null);
	Loan loan=new Loan(1,"home",230000,3,2);
	user.setLoans(Arrays.asList(loan));
	List<User> users = new ArrayList<User>();
	users.add(user);
	when(bankService.usersService()).thenReturn(users);
	mockMvc.perform(get("/users")).andExpect(status().isOk());
}

@Test
void testUsersgt5L() throws Exception {
	Usersgt5L usersgt5l=new Usersgt5L("pavan","home", 4500000);
	List<Usersgt5L> usersgt5ls=new ArrayList<Usersgt5L>();
	usersgt5ls.add(usersgt5l);
	when(bankService.usersgt5LService()).thenReturn(usersgt5ls);
	mockMvc.perform(get("/usersabovefiveL")).andExpect(status().isOk());
}


private String mapToJson(Object object) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(object);
}

}




//
//@Autowired
//private MockMvc mockMvc;
//
//@MockBean 
//BankService bankService;
//
//private static ObjectMapper mapper=new ObjectMapper();
//
//@Test
//void testRegister() throws Exception {
//	User user=new User(1,"pavan","pavan","pavan",(long) 1234,null);
//	when((bankService.registerService((User) any(User.class)))).thenReturn(user);
//	MvcResult result=(MvcResult) mockMvc.perform(post("/newuser")).andExpect(status().isCreated());
//}
//
////@Test
////void testUpdateUser() {
////	fail("Not yet implemented");
////}
////
////@Test
////void testApplyLoan() {
////	fail("Not yet implemented");
////}
////
////@Test
////void testUsers() {
////	fail("Not yet implemented");
////}
////
////@Test
////void testUsersgt5L() {
////	fail("Not yet implemented");
////}
//
