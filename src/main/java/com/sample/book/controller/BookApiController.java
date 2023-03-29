package com.sample.book.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sample.book.dto.BookDTO;
import com.sample.book.service.BookService;

@RestController
@RequestMapping("/bookapi/*")
public class BookApiController {
	
	@Autowired
	BookService service;
	
	@GetMapping(value = "/getList")
	public List<BookDTO> listJsonDTO(@RequestParam Map<String, Object> map) {
		List<BookDTO> list = this.service.selectList(map);
		return list;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public BookDTO detail(BookDTO dto) {
		int rs = service.updateQuantity(dto);
//		System.out.println(rs);
		BookDTO detail = service.selectDetail(dto);
//		System.out.println(dto);
//		System.out.println(detail);
		return detail;
	}
	
	
}
