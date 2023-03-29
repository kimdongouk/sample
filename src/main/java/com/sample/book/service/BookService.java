package com.sample.book.service;

import java.util.List;
import java.util.Map;

import com.sample.book.dto.BookDTO;

public interface BookService {
	
	public int insert(Map<String, String> map);
	public List<BookDTO> selectList(Map<String, Object> map);
	public Map<String, Object> selectDetail(Map<String, Object> map);
	public int update(Map<String, String> map);
	public int delete(Map<String, String> map);
	
	public int insert(BookDTO dto);
	public List<BookDTO> selectList(BookDTO dto);
	public BookDTO selectDetail(BookDTO dto);
	public int update(BookDTO dto);
	public int delete(BookDTO dto);
	public int updateQuantity(BookDTO dto);
}
