package com.springbook.biz.board;

import java.util.List;

// CRUD기능 메소드 구현
public interface BoardService {
	
	// 1. 등록
	void insertBoard(BoardVO vo);
	
	// 2. 수정
	void updateBoard(BoardVO vo);

	// 3. 삭제
	void deleteBoard(BoardVO vo);

	// 4. 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 5. 글 전체 조회
	List<BoardVO> getBoardList(BoardVO vo);	
	
}
