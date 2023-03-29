package com.sample.book.controller;

import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sample.book.dto.BookDTO;
import com.sample.book.service.BookService;

@Controller
public class BookControllerMap {

	@Autowired
	BookService bookService;
	
	public BookControllerMap() {
		System.out.println("@Controller 스프링 자동생성");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(BookControllerMap.class);
	
	
	@RequestMapping(value = "/listMap", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		System.out.println(map);
		List<BookDTO> list = this.bookService.selectList(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list); // request.setAttribute("data",list);
		mav.setViewName("book/list");
		return mav;
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
	
	@RequestMapping(value = "/detailMap", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detail = this.bookService.selectDetail(map);
//		System.out.println(detail);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail); // request.setAttribute("data",list);
		mav.setViewName("book/detail");
		return mav;
	}
	
	@RequestMapping(value = "/updateMap", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		Map<String, Object> data = this.bookService.selectDetail(map);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/update");
		mav.addObject("data", data);
		return mav;
	}
	
	@RequestMapping(value = "/updateMap", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, String> map) {
		System.out.println(map);
		int rs = this.bookService.update(map);
		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("redirect:/detail?book_id="+map.get("book_id"));
		} else {
			mav.setViewName("redirect:/update?book_id="+map.get("book_id"));
		}
		return mav;
	}
	
	@RequestMapping(value="/deleteMap", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam Map<String, String> map) {
		System.out.println(map);
		ModelAndView mav = new ModelAndView();
		int rs = this.bookService.delete(map);
		if(rs == 1) {
			mav.setViewName("redirect:/list");
		} else {
			mav.setViewName("redirect:/detail?book_id="+map.get("book_id"));
		}
		return mav;
	}
	
	@RequestMapping(value="/createMap", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	@RequestMapping(value="/createMap", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
//		System.out.println(map);
//		service 
		int rs = bookService.insert(map);
//		move
		if(rs == 1) {
			mav.setViewName("redirect:/list");
		} else {
			mav.setViewName("redirect:/create");
		}
		return mav;
	}
	
}
