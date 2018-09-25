package com.agsft.springaudit.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.springaudit.data.accessor.UserEntityRepository;
import com.agsft.springaudit.data.entity.UserEntity;
import com.agsft.springaudit.exception.ConversionException;
import com.agsft.springaudit.service.creator.IUserService;
import com.agsft.springaudit.util.PojoObjectMapper;
import com.agsft.springaudit.web.model.UserDTO;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserEntityRepository repository;

	@Autowired
	private PojoObjectMapper objectMapper;

	@Override
	public UserDTO searchById(int userId) throws ConversionException {

		return objectMapper.convertValue(repository.findById(userId), UserDTO.class);
	}

	@Override
	public UserDTO save(UserDTO user) throws ConversionException {
		return objectMapper.convertValue(repository.save(objectMapper.convertValue(user, UserEntity.class)),
				UserDTO.class);
	}

	@Override
	public UserDTO update(UserDTO user) throws ConversionException {
		return objectMapper.convertValue(repository.save(objectMapper.convertValue(user, UserEntity.class)),
				UserDTO.class);
	}

}
