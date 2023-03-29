package com.sample.book.service;

import java.util.List;
import java.util.Map;

import com.sample.book.dto.BoardDTO;
import com.sample.book.dto.BookDTO;

public interface BoardService {
	public List<BoardDTO> selectList(Map<String, Object> map);
	public int insert(BoardDTO dto);
	public BoardDTO selectDetail(BoardDTO dto);
	public int updateCnt(BoardDTO dto);
	public int update(BoardDTO dto);
	public int delete(BoardDTO dto);
}
