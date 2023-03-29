package com.sample.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.book.dao.BoardDao;
import com.sample.book.dao.BookDao;
import com.sample.book.dto.BoardDTO;
import com.sample.book.dto.BookDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao dao;
	
	public BoardServiceImpl() {
		System.out.println("@Service 스프링 자동생성");
	}
	
	@Override
	public List<BoardDTO> selectList(Map<String, Object> map) {
		return dao.selectList(map);
	}
	
	@Override
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}
	
	@Override
	public BoardDTO selectDetail(BoardDTO dto) {
		return dao.selectDetail(dto);
	}
	
	@Override
	public int updateCnt(BoardDTO dto) {
		return dao.updateCnt(dto);
	}
	
	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(BoardDTO dto) {
		return dao.delete(dto);
	}
	
}
