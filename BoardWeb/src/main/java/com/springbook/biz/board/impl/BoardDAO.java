package com.springbook.biz.board.impl;

// import java.sql.*는 모든 것을 import하고 시작하기에, 너무 느려짐ㅇㅇ
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// DAO클래스 - data access object
@Repository("boardDAO") // repo? -> 직.접.적으로 db연동하는 부분(쿼리를 여기서 날리잖아)
public class BoardDAO {
	// 0. JDBC 관련변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null; // = RecordSet (한행 한행들의 모임인 set)
	
	// 1. SQL 명령어들 - final로 고정시킴! - 상수화 & h2에 만들어둔 테이블명 입력ㅇㅇ->board
		// insert의 nvl? -> null_value약자 & 찾아보고 nvl(a,0) -> a값이 null이면 0반환 / 아니면 a값 그대로ㄱㄱ
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?"; // 물음표3개네 -> setString()3개
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	// 2. CRUD기능의 메소드 구현
	// 2-1. 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle()); // setter,getter의 getterㅇㅇ.
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn); //stmt.close(), conn.close() 두 줄 대체! - 단순히 2줄은 아님. 각 분기처리해야되니. 쨋든 개념ㅇㅇ 
		}
	}
	
	// 2-2. 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1,  vo.getTitle());
			stmt.setString(2,  vo.getContent());
			stmt.setInt(3,  vo.getSeq()); // seq는 pk고, 이건 int타입이었음
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 2-3. 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1,  vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 2-4. 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null; // 이거 넣어야 할 듯ㅇㅇ!
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			System.out.println(vo); //  seq가 왜 초기값인 0이 나오지?
			System.out.println(vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				// TODO: 근데, 이렇게 아래 일일이 세팅하는거 좀 비효율적인거 같은데..? 원래 이렇게 함?
				// TODO: 아니면 기초라 걍 이렇게 하는거임??
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return board;
	}
	
	// 2-4-2. 글 전체 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo) { // 변수 필요없지 이건..
			System.out.println("===> JDBC로 getBoardList() 기능 처리");
			List<BoardVO> boardList = new ArrayList<BoardVO>();
			try {
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(BOARD_LIST);
				rs = stmt.executeQuery();
				while (rs.next()) {
					BoardVO board = new BoardVO();
					board.setSeq(rs.getInt("SEQ"));
					board.setTitle(rs.getString("TITLE"));
					board.setWriter(rs.getString("WRITER"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegDate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
					boardList.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return boardList;
		}
}
