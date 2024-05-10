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
@Repository("boardDAO")
public class BoardDAO {
	// 0. JDBC 관련변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null; // = RecordSet (한행 한행들의 모임인 set)
	
	// 1. SQL 명령어들 - final로 고정시킴! - 상수화 & h2에 만들어둔 테이블명 입력ㅇㅇ->board
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
			conn = JDBCUtil.getConneciton();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle()); // setter,getter의 getterㅇㅇ.
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 2-2. 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConneciton();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1,  vo.getTitle());
			stmt.setString(2,  vo.getContent());
			stmt.setInt(3,  vo.getSeq());
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
			conn = JDBCUtil.getConneciton();
			stmt = conn.prepareStatement(BOARD_DELETE); // TODO: BOARD_DELETE는 어디서 들어온겨?
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
			conn = JDBCUtil.getConneciton();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1,  vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next() ) {
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
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===> JDBC로 getBoardList() 기능 처리");
			List<BoardVO> boardList = new ArrayList<BoardVO>();
			try {
				conn = JDBCUtil.getConneciton();
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
