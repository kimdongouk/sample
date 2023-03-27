package com.sample.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.dao.BookDao;

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
	public List<Map<String, Object>> selectList(Map<String, Object> map) {
		return bookDao.selectList(map);
	}
	
	@Override
	public Map<String, Object> selectTitle(Map<String, Object> map) {
		return bookDao.selectTitle(map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return bookDao.selectDetail(map);
	}
	
	public int update(Map<String, String> map) {
		return bookDao.update(map);
	}
	
	@Override
	public int delete(Map<String, String> map) {
		int rs = bookDao.delete(map);
		return rs;
	}
}
