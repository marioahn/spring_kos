package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board") // 여기도 이거 있어야 writer등이 null로 업데이트되지 않겠지!(p.394~)
public class GetBoardController {
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		mav.addObject("board", boardDAO.getBoard(vo)); // Model정보 저장
		mav.setViewName("getBoard.jsp"); // View정보 저장
		
		return mav;
	}
}

// @Override
//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//System.out.println("글 상세 조회 처리");
//// 1. 검색할 게시글 번호 추출
//String seq = request.getParameter("seq");
//
//// 2. DB연동 처리
//BoardVO vo = new BoardVO();
//vo.setSeq(Integer.parseInt(seq));
//
//BoardDAO boardDAO = new BoardDAO();
//BoardVO board = boardDAO.getBoard(vo);
//
//// 3. 검색 결과를 세션에 저장하고, 상세 화면으로 이동한다
//// HttpSession session = request.getSession();
//// session.setAttribute("board", board);
//// return "getBoard";
//
//// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다
//ModelAndView mav = new ModelAndView();
//mav.addObject("board", board);
//// mav.setViewName("getBoard.jsp"); // 여기서 getBoard.do가는게 아니지ㅇㅇ! GetBoardControl클래스 자체가 "do"임ㅇㅇ; & viewResolver적용 전
//mav.setViewName("getBoard"); // View정보 저장
//return mav;
//}