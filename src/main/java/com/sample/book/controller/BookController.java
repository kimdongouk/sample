package com.sample.book.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sample.book.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	public BookController() {
		System.out.println("@Controller 스프링 자동생성");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String,Object>> list = this.bookService.selectList(map);
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
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detail = this.bookService.selectDetail(map);
//		System.out.println(detail);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail); // request.setAttribute("data",list);
		mav.setViewName("book/detail");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, String> map) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/update");
		mav.addObject("data", map);
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, String> map) {
		System.out.println(map);
		int rs = this.bookService.update(map);
		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("book/list");
		} else {
			mav.setViewName("redirect:/update");
		}
		return mav;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam Map<String, String> map) {
		System.out.println(map);
		ModelAndView mav = new ModelAndView();
		int rs = this.bookService.delete(map);
		mav.setViewName("redirect:/list");
		return mav;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
	
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
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
