package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// TODO: 엥? 이거 test가 실제 구동하는 test말한거였음? test코드가 아니라?
public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring컨테이너를 구동한다
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring컨테이너로부터 BoardServiceImpl객체를 L.ook.up한다!
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용.....");
		boardService.insertBoard(vo);
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board: boardList) {
			System.out.println("===> " + board.toString());
		}
		
		// 수정, 삭제도 해보기
		
		// 5. Spring 컨테이너 종료
		container.close();
	}
}
