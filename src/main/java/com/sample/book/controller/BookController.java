package com.sample.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sample.book.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	public BookController() {
		System.out.println("@Controller 스프링 자동생성");
	}
}
