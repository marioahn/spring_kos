package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;
// TODO: 어라라.. 왜 import가 안들어와도 에러가 안나지..? 버그인가>

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		// 0. 사용자 입력 정보 추출(for 검색 기능 - 나중에 구현)
		// 1. DB연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 2. 검색 결과를 세.션.에 저장하고 목록 화면으로 이동한다 
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList); 
		// response.sendRedirect("getBoardList.jsp");
		return "getBoardList";
	}
}
