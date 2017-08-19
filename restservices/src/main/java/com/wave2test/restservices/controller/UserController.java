package com.wave2test.restservices.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wave2test.backendmodule.dao.AccountDao;
import com.wave2test.backendmodule.model.Account;


@RestController
public class UserController {
	
	@Autowired
	AccountDao accountDao;
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody Account account)
	{
		Boolean b=accountDao.createAccount(account);
		if(b)
		{
			return new ResponseEntity<Boolean>(b,HttpStatus.CREATED);
		}else
		{
			return new ResponseEntity<Boolean>(b,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Account> login(@RequestBody Account account,HttpSession session)
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

}
