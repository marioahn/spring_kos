package com.springbook.view.board;

import org.springframework.stereotype.Controller; // @Controller는 아래가 아니라 이거임
// import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

// POJO스타일로 구현!
@Controller
public class InsertBoardController {

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) { // HttpServletRequest request대신에, BoardVo vo가 매개변수로
		System.out.println("글 등록 처리");
		
		boardDAO.insertBoard(vo);
		return "getBoardList.do"; // redirectㅇㅇ
	}
}


//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("글 등록 처리");
//		// 1. 사용자 입력 정보 추출
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		// 2. DB연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//		
//		// 3. 화면 네비게이션
//		// return "getBoardList.do"; // do는 꼭 .do붙여주기!
//		ModelAndView mav = new ModelAndView();
//		// mav.setViewName("getBoardList.do"); // 여기로 가야하니까. getBoardList.jsp로 하면 업데이트 안되겠지
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
//	}