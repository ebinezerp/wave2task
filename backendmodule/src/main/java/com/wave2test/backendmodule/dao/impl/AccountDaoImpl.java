package com.wave2test.backendmodule.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wave2test.backendmodule.dao.AccountDao;
import com.wave2test.backendmodule.model.Account;

@Repository("accountDao")
@Transactional
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createAccount(Account account) {
		try {
			sessionFactory.getCurrentSession().save(account);
			return true;
		
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e);
			return false;
		}
	}
	
	
	

}
