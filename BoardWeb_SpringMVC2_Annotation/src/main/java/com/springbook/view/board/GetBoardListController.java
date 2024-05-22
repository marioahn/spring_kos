package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	
	// Step1: 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // conditionMap이란 모델에 아래 내용들을 저장할거고, jsp에서 쓸거라는 뜻임!!
	// 아래 getBoardList메서드에서 매개변수로 Model model이 있지? 이게 바로 그거인 셈!
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	// Step2: 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		// Model 정보 저장
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp"; // View이름 리턴
	}
}

// (p.388~9)
//@RequestMapping("/getBoardList.do")
//public String getBoardList(
//		@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
//		@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
//		BoardVO vo,
//		BoardDAO boardDAO,
//		Model model // 이거 새로 나왔네. 흠 뭐지 이건?
//		// -> String return이면 MAV안쓰는거니까. return View니까 Model은 저장할 게 있어야하지. 그게 Model객체임
//) {
//	System.out.println("검색조건: " + condition);
//	System.out.println("검색 단어: " + keyword);
//	// Model정보 저장
//	model.addAttribute("boardList", boardDAO.getBoardList(vo));
//	return "getBoardList.jsp";
//}


//@RequestMapping("/getBoardList.do")
//public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//	// 오우, vo, dao, mav이렇게 3개를 받네 여기선!
//	mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model정보 저장
//	mav.setViewName("getBoardList.jsp"); // View정보 저장
//	
//	return mav;
//}


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