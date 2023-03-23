package com.sample.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookdao;
	
	public BookServiceImpl() {
		System.out.println("@Service 스프링 자동생성");
	}
}
