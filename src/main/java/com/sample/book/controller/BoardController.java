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
import org.springframework.web.servlet.ModelAndView;

import com.sample.book.dto.BoardDTO;
import com.sample.book.dto.BookDTO;
import com.sample.book.service.BoardService;
import com.sample.book.service.BookService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService service;
	
	public BoardController() {
		System.out.println("@Controller 스프링 자동생성");
	}
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@GetMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<BoardDTO> list = this.service.selectList(map);
		System.out.println(map);
		System.out.println(list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list); // request.setAttribute("data",list);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("board/create");
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView createPost(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
//		System.out.println(map);
//		service 
		int rs = service.insert(dto);
//		move
		if(rs == 1) {
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("redirect:create");
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO dto) {
		int rs = service.updateCnt(dto);
//		System.out.println(rs);
		BoardDTO detail = service.selectDetail(dto);
		System.out.println(dto);
		System.out.println(detail);
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detail); // request.setAttribute("data",list);
		mav.setViewName("board/detail");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(BoardDTO dto) {
		BoardDTO data = service.selectDetail(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/update");
		mav.addObject("data", data);
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePost(BoardDTO dto) {
		System.out.println(dto);
		int rs = service.update(dto);
		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("redirect:detail?seq="+dto.getSeq());
		} else {
			mav.setViewName("redirect:update?seq="+dto.getSeq());
		}
		return mav;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView delete(BoardDTO dto) {
		System.out.println(dto);
		ModelAndView mav = new ModelAndView();
		int rs = service.delete(dto);
		if(rs == 1) {
			mav.setViewName("redirect:list");
		} else {
			mav.setViewName("redirect:detail?seq="+dto.getSeq());
		}
		return mav;
	}
	
}
