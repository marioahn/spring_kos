package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class UpdateBoardController {
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("번호: " + vo.getSeq());
		System.out.println("제목: " + vo.getTitle());
		System.out.println("작성자: " + vo.getWriter());
		System.out.println("내용 " + vo.getContent());
		System.out.println("등록일: " + vo.getRegDate());
		System.out.println("조회수: " + vo.getCnt());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
}

//@Override
//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//	System.out.println("글 수정 처리");
//	// 1. 사용자 입력 정보 추출
//	String title = request.getParameter("title");
//	String content = request.getParameter("content");
//	String seq = request.getParameter("seq");
//
//	// 2. DB연동 처리
//	BoardVO vo = new BoardVO();
//	vo.setTitle(title); 
//	vo.setContent(content);
//	vo.setSeq(Integer.parseInt(seq));
//	BoardDAO boardDAO = new BoardDAO();
//	boardDAO.updateBoard(vo);
//	
//	// 3. 화면 네비게이션
//	// return "getBoardList.do";
//	ModelAndView mav = new ModelAndView();
//	// mav.setViewName("getBoardList.do");
//	mav.setViewName("redirect:getBoardList.do");
//	return mav;
//}