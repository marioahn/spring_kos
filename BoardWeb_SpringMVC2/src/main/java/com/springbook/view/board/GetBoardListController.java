package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		// 0. 사용자 입력 정보 추출(for 검색 기능 - 나중에 구현)
		// 1. DB연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// (old)2. 검색 결과를 세.션.에 저장하고 목록 화면으로 이동한다 
		// HttpSession session = request.getSession();
		// session.setAttribute("boardList", boardList); 
		// return "getBoardList";
		
		// 2. 검색 결과와 화면
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // model정보 저장
		mav.setViewName("getBoardList.jsp"); // view정보 저장
		
		return mav;
	}
}
