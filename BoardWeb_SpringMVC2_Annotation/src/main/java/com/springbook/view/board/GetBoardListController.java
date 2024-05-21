package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		// 오우, vo, dao, mav이렇게 3개를 받네 여기선!
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model정보 저장
		mav.setViewName("getBoardList.jsp"); // View정보 저장
		
		return mav;
	}
	
}

//@Override
//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//	System.out.println("글 목록 검색 처리");
//	
//	// 0. 사용자 입력 정보 추출(for 검색 기능 - 나중에 구현)
//	// 1. DB연동 처리
//	BoardVO vo = new BoardVO();
//	BoardDAO boardDAO = new BoardDAO();
//	List<BoardVO> boardList = boardDAO.getBoardList(vo);
//	
//	// (old)2. 검색 결과를 세.션.에 저장하고 목록 화면으로 이동한다 
//	// HttpSession session = request.getSession();
//	// session.setAttribute("boardList", boardList); 
//	// return "getBoardList";
//	
//	// 2. 검색 결과와 화면
//	ModelAndView mav = new ModelAndView();
//	mav.addObject("boardList", boardList); // model정보 저장
//	// mav.setViewName("getBoardList.jsp"); // view정보 저장 & viewResolver적용 전
//	mav.setViewName("getBoardList"); // .jsp생략한다. viewResolver가 pre,suffix붙이기 때문
//	// -> 최종경로: /WEB-INF/board/getBoardList.jsp를 실행!
//	
//	return mav;
//}