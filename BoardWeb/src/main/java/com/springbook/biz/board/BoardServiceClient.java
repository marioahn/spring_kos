package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring컨테이너를 구동한다
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring컨테이너로부터 BoardServiceImpl객체를 L.ook.up한다!
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 시작 - 초기화 및 할당
		BoardVO vo = new BoardVO();
		// 3. 글 등록
		
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용.....");
		boardService.insertBoard(vo);
		
		// 4. 글 전체 검색 - boardService.getBoardList함수도 매개변수 사실 필요없음
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board: boardList) {
			System.out.println("=> " + board.toString());
		}
		
		// TODO: 4-2. 글 상세 조회(seq입력인데, 이거 어케하냐?? - 어라? id입력이 매개변수가 아닌데?)
			// 위에서 선언한 vo로 조회해야하는데.. 좀 너무 이상하네. 우리가 선택해서 고를 수 있는건 아니잖아 -> 초기버젼이니 뭐..
			// 원래는 client(프론트,view단)에서 요청(ex: 회원가입 시, 정보 쭉 입력해서 send)하면 그거 받아서 하면 되니
		/* 의문: 어. 근데 그전에 아예 찾지를 못하는데? -> 아; setSeq를 안했잖아. vo는 찾아진게 아니다
			- 그렇지 맞음. vo를 바탕으로 함수안에서 board를 만드는데, 이 vo는 현재에선 seq정보가 없음. set안했으니까
			- vo는 실제 DB에 있는 vo가 아니라, 임시로 만든 vo라서 불완전함ㅇㅇ;; 
			- 그래서 아래로 찾아와도 null값이 나오는거지 -> vo가 아니라, 실제 DB조회가 되도록, seq(pk)값이 필요함
		*/ 
		System.out.println("상세조회: " + boardService.getBoard(vo)); // 이거 null이 나옴
		
		// 수정, 삭제도 해보기 -> .. 너무 에반데.. 
		
		// 5. Spring 컨테이너 종료
		container.close();
	}
}
