package com.springboot.jooq.service;

import org.springframework.transaction.annotation.Transactional;

public interface IBookService {

	@Transactional
	void create(int id, int authorId, String title);
}
