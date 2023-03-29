package com.sample.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.dao.BookDao;
import com.sample.book.dto.BookDTO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	public BookServiceImpl() {
		System.out.println("@Service 스프링 자동생성");
	}
	
	@Override
	public int insert(Map<String, String> map) {
		int rs = bookDao.insert(map);
		return rs;
	}
	
	@Override
	public int insert(BookDTO dto) {
		int rs = bookDao.insert(dto);
		return rs;
	}
	
	@Override
	public List<BookDTO> selectList(Map<String, Object> map) {
		return bookDao.selectList(map);
	}
	
	@Override
	public List<BookDTO> selectList(BookDTO dto) {
		return bookDao.selectList(dto);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return bookDao.selectDetail(map);
	}
	
	public BookDTO selectDetail(BookDTO dto){
		return bookDao.selectDetail(dto);
	}
	
	public int update(Map<String, String> map) {
		return bookDao.update(map);
	}
	
	public int update(BookDTO dto) {
		return bookDao.update(dto);
	}
	
	@Override
	public int delete(Map<String, String> map) {
		int rs = bookDao.delete(map);
		return rs;
	}
	
	@Override
	public int delete(BookDTO dto) {
		int rs = bookDao.delete(dto);
		return rs;
	}
	
	@Override
	public int updateQuantity(BookDTO dto) {
		int rs = bookDao.updateQuantity(dto);
		return rs;
	}
}
