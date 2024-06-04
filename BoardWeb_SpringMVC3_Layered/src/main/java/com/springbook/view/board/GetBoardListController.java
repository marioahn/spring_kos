package com.springbook.view.board;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	@Autowired
	private BoardService boardService;

	
	// Step1: 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // conditionMap이란 모델에 아래 내용들을 저장할거고, jsp에서 쓸거라는 뜻임!!
	public Map<String, String> searchConditionMap() {
		// HashMap은 순서보장x여서, 아래가 순서대로 되지 않음. 
		Map<String, String> conditionMap = new LinkedHashMap<String, String>();
		conditionMap.put("전체로", "ALL");
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		// conditionMap.put("작성자", "WRITER");
		// conditionMap.put("작성일자", "REGDATE");
		return conditionMap;
	}
	
	// Step2: 글 전체 조회
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) { // BoardDAO boardDAO 변수로 필요 없음 이제
		
		// for 검색 기능!
		// 아래 조건이 있어야 전체조회가 제대로 된다.. BoardDAO에서 else 쿼리(BOARD_LIST)가 없어도 되는 이유!!!!
		if(vo.getSearchCondition() == null)	vo.setSearchCondition("TITLE");
		
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword(""); // 여기서 null로 하면 제대로 안먹히네 - text값이 없는 경우!(client에서)
		else if (vo.getSearchKeyword().isEmpty()) vo.setSearchKeyword("99999999999999"); // 이거 추가!
		
		// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));
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