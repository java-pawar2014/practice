package org.spring.bootdi.service.handler;

import org.spring.bootdi.data.accessor.AccountAccessor;
import org.spring.bootdi.data.model.AccountEntity;
import org.spring.bootdi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingAccountServiceHandler implements AccountService {

	@Autowired
	private final AccountAccessor accountAccessor;

	public SavingAccountServiceHandler(AccountAccessor accountAccessor) {
		this.accountAccessor = accountAccessor;
		System.out.println("SavingAccountServiceHandler created...");
	}

	@Override
	public AccountEntity findByAccountNumber() {
		return null;
	}

}
