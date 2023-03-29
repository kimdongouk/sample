package com.sample.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.book.dto.BookDTO;

@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public BookDao() {
		System.out.println("@Repository 스프링 자동생성");
	}
	
	public int insert(Map<String, String> map) {
		return sqlSessionTemplate.insert("bookMap.insert",map);
	}
	
	public int insert(BookDTO dto) {
		return sqlSessionTemplate.insert("book.insert",dto);
	}
	
	public List<BookDTO> selectList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("bookMap.select_list", map);
	}
	
	public List<BookDTO> selectList(BookDTO dto) {
		return sqlSessionTemplate.selectList("book.select_list", dto);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return sqlSessionTemplate.selectOne("bookMap.select_detail", map);
	}
	
	public BookDTO selectDetail(BookDTO dto){
		return sqlSessionTemplate.selectOne("book.select_detail", dto);
	}
	
	public int update(Map<String, String> map){
		return sqlSessionTemplate.update("bookMap.update", map);
	}
	
	public int update(BookDTO dto){
		return sqlSessionTemplate.update("book.update", dto);
	}
	
	public int delete(Map<String, String> map){
		return sqlSessionTemplate.update("bookMap.delete", map);
	}
	
	public int delete(BookDTO dto){
		return sqlSessionTemplate.update("book.delete", dto);
	}
	
	public int updateQuantity(BookDTO dto){
		return sqlSessionTemplate.update("book.updateQuantity", dto);
	}
	
}
