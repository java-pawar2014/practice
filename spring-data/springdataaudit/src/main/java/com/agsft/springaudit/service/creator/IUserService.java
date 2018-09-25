package com.agsft.springaudit.service.creator;

import com.agsft.springaudit.exception.AuditingException;
import com.agsft.springaudit.web.model.UserDTO;

public interface IUserService {

	UserDTO searchById(int userId) throws AuditingException;

	UserDTO save(UserDTO user) throws AuditingException;

	UserDTO update(UserDTO user) throws AuditingException;

}
