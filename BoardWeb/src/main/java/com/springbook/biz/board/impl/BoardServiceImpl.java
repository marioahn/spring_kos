package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService") // 서비스 어노테이션!
public class BoardServiceImpl implements BoardService{
	@Autowired // 자동생성 - bean대신임.
	private BoardDAO boardDAO;
	
	// 교재엔 왜 다 override안했지?
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);		
	}
	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);		
	}
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);		
	}
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
}
