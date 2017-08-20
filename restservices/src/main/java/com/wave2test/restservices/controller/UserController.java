package com.wave2test.restservices.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave2test.backendmodule.dao.AccountDao;
import com.wave2test.backendmodule.model.Account;


@RestController
public class UserController {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	HttpSession session;
	
	@PostMapping("/register")
	public ResponseEntity<Map<String,String>> register(@RequestBody @Valid Account account,BindingResult result,HttpServletResponse response,HttpServletRequest request)
	{
		Map<String,String> errorMap=new HashMap<String,String>();
		System.out.println("result of the account object::::"+result.hasErrors());
		if(result.hasErrors())
		{
			System.out.println("error occured");
			
			
		for(FieldError error:result.getFieldErrors())
		{
		  
		  errorMap.put(error.getField(),error.getDefaultMessage());
		}
		
		     
		 
		     return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		else{
		Boolean b=accountDao.createAccount(account);
		
		if(b)
		{
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.CREATED);
		}else
		{
			 return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Account> login(@RequestBody Account account)
	{
		Account act= accountDao.getUserByUserName(account.getUserName());
		if(act!=null)
		{
			session.setAttribute("username", act.getUserName());
			return new ResponseEntity<Account>(act, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Account>(act,HttpStatus.UNAUTHORIZED);
		}
	}
	
	/*@PostMapping("/error")
	public ResponseEntity<Map<String,String>> errorMessages(@RequestAttribute("errorMap") Object errorMap)
	{
		
		
		Map<String, String> errorMapm=(Map<String,String>)errorMap;
		for(String s:errorMapm.values())
		{
			System.out.println(s);
		}
		return new ResponseEntity<Map<String,String>>(errorMapm,HttpStatus.BAD_REQUEST);
	}*/
	
	@GetMapping("/logout")
	public ResponseEntity<Boolean> logout()
	{
		try{
		session.removeAttribute("username");
		session.invalidate();
		return new ResponseEntity<Boolean>(true,HttpStatus.FORBIDDEN);
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e);
			return new ResponseEntity<Boolean>(false,HttpStatus.EXPECTATION_FAILED);
		}
		
	}

}
