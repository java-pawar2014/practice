package org.spring.bootdi.service;

import org.spring.bootdi.data.model.AccountEntity;

public interface AccountService {
	
	AccountEntity findByAccountNumber();
}
