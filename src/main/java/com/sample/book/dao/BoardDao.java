package com.sample.book.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.book.dto.BoardDTO;
import com.sample.book.dto.BookDTO;

@Repository
public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDao() {
		System.out.println("@Repository 스프링 자동생성");
	}
	
	public List<BoardDTO> selectList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("board.select_list", map);
	}
	
	public int insert(BoardDTO dto) {
		return sqlSessionTemplate.insert("board.insert", dto);
	}
	
	public BoardDTO selectDetail(BoardDTO dto) {
		return sqlSessionTemplate.selectOne("board.select_detail", dto);
	}
	
	public int updateCnt(BoardDTO dto) {
		return sqlSessionTemplate.update("board.update_cnt", dto);
	}
	
	public int update(BoardDTO dto) {
		return sqlSessionTemplate.update("board.update", dto);
	}
	
	public int delete(BoardDTO dto) {
		return sqlSessionTemplate.delete("board.delete", dto);
	}
	
}
