package com.springboot.jooq.service.handler;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jooq.service.IBookService;

public class DefaultBookSerivce implements IBookService {

	@Autowired
	DSLContext dsl;

	@Override
	@Transactional
	public void create(int id, int authorId, String title) {

		for (int i = 0; i < 2; i++)
			dsl.insertInto().set(BOOK.ID, id).set(BOOK.AUTHOR_ID, authorId).set(BOOK.TITLE, title).execute();
	}
}
