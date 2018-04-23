package org.spring.bootdi.data.accessor;

import org.springframework.stereotype.Component;

@Component
public class AccountAccessor {
	
	public AccountAccessor() {
		System.out.println("AccountAccessor created...");
	}
}
