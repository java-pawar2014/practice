package com.agsft.springaudit.config.aware;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component(value = "AuditorAwareTriggerer")
public class AuditorAwareTriggerer implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Pawar");
	}
}
// @Component(value="AuditorAwareTriggerer")
// public class AuditorAwareTriggerer implements AuditorAware<UserDTO> {
//
// @Override
// public Optional<UserDTO> getCurrentAuditor() {
// Authentication authentication =
// SecurityContextHolder.getContext().getAuthentication();
// if (authentication == null || !authentication.isAuthenticated()) {
// return null;
// }
// return Optional.of((UserDTO) authentication.getPrincipal());
// }
// }
