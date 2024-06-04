package com.springbook.view.board;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // @Controller는 아래가 아니라 이거임
// import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

// POJO스타일로 구현!
@Controller
public class InsertBoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException { // HttpServletRequest request대신에, BoardVo vo가 매개변수로
		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		System.out.println("vo.setUpload안해도 되냐?? 이 값 제대로 나오냐?" + vo.getUploadFile()); // 제대로 나온다!
		// MultipartFile[field="uploadFile", filename=윤하.jpg, contentType=image/jpeg, size=7271]
		
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "C:/Users/A/1-eclipse-workspace/sts/work_space3/BoardWeb_SpringMVC3_Layered/src/main/webapp/resources/upload/boardUploadFile/" + fileName;
			
			uploadFile.transferTo(new File(filePath)); // 파일 저장!!
			// vo.setUploadFile(uploadFile); // 이걸 할 필요가 없음. 이미 위에서 vo.getUploadFile()하면 값이 나옴.
			// 클라에서 넘어오면서 자동으로 세팅이 된 상태임. 당연하지 후;;
		}		
		// boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		return "getBoardList.do"; 
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