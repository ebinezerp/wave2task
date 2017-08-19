package com.wave2test.restservices.controller;

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

}
