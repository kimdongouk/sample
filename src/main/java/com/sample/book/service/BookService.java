package com.sample.book.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	
	public int insert(Map<String, String> map);
	
	public List<Map<String, Object>> selectList(Map<String, Object> map);
	
	public Map<String, Object> selectTitle(Map<String, Object> map);
	
	public Map<String, Object> selectDetail(Map<String, Object> map);
	
	public int update(Map<String, String> map);
	
	public int delete(Map<String, String> map);
	
}
