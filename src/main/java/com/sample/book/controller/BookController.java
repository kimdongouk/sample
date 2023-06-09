package com.sample.book.controller;

import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sample.book.dto.BookDTO;
import com.sample.book.service.BookService;

@Controller
@RequestMapping("/book/*")
public class BookController {

	@Autowired
	BookService bookService;
	
	public BookController() {
		System.out.println("@Controller 스프링 자동생성");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<BookDTO> list = this.bookService.selectList(map);
		System.out.println(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list); // request.setAttribute("data",list);
		mav.setViewName("book/list");
		return mav;
	}
	
	@GetMapping(value = "/listJsonDTO")
	@ResponseBody
	public List<BookDTO> listJsonDTO(@RequestParam Map<String, Object> map) {
		List<BookDTO> list = this.bookService.selectList(map);
		return list;
	}
	
	@GetMapping(value = "/bookSearch")
	public String bookSearch() {
		return "book/bookSearch";
	}
	
	
	
//	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public ModelAndView detail(@RequestParam Map<String, Object> map) {
//		Map<String,Object> data = this.bookService.selectTitle(map);
//		ModelAndView mav = new ModelAndView();
//		System.out.println(data);
//		mav.addObject("data", data); // request.setAttribute("data",list);
//		mav.setViewName("book/detail");
//		return mav;
//	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(BookDTO dto) {
		int rs = this.bookService.updateQuantity(dto);
//		System.out.println(rs);
		BookDTO detail = this.bookService.selectDetail(dto);
//		System.out.println(dto);
//		System.out.println(detail);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail); // request.setAttribute("data",list);
		mav.setViewName("book/detail");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(BookDTO dto) {
		BookDTO data = this.bookService.selectDetail(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/update");
		mav.addObject("data", data);
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(BookDTO dto) {
		System.out.println(dto);
		int rs = this.bookService.update(dto);
		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("redirect:detail?book_id="+dto.getBook_id());
		} else {
			mav.setViewName("redirect:update?book_id="+dto.getBook_id());
		}
		return mav;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView delete(BookDTO dto) {
		System.out.println(dto);
		ModelAndView mav = new ModelAndView();
		int rs = this.bookService.delete(dto);
		if(rs == 1) {
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("redirect:detail?book_id="+dto.getBook_id());
		}
		return mav;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView createPost(BookDTO dto) {
		ModelAndView mav = new ModelAndView();
//		System.out.println(map);
//		service 
		int rs = bookService.insert(dto);
//		move
		if(rs == 1) {
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("redirect:create");
		}
		return mav;
	}
	
}
