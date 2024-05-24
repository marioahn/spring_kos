package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//DAO(Data Access Object)
@Repository("boardDAO")
public class BoardDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어들
	// nvl은 null일경우 뒤의값, 아닐경우 앞의값을 return
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content, upload) values((select nvl(max(seq), 0)+1 from board),?,?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	// 검색기능 위한 쿼리
	private final String BOARD_tLIST = "select * from board "
			+ "where title like '%'||?||'%' order by seq desc";
	private final String BOARD_cLIST = "select * from board "
			+ "where content like '%'||?||'%' order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection(); // test db 가르킴
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle()); //1번 ?
			stmt.setString(2, vo.getWriter()); //2번 ?
			stmt.setString(3, vo.getContent()); //3번 ?
			stmt.setString(4, vo.getUploadFile().getOriginalFilename()); //4번 ?
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//conn.close();
			//stmt.close();
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				board.setFileName(rs.getString("UPLOAD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}

	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			if (vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_tLIST);
				stmt.setString(1, vo.getSearchKeyword());
			} else if (vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_cLIST);
				stmt.setString(1, vo.getSearchKeyword());
			} else if (vo.getSearchCondition().equals("ALL")) {
				stmt = conn.prepareStatement(BOARD_LIST);
			}
			// else문에 {stmt = conn.prepareStatement(BOARD_LIST);}는 필요없겠네. 
			// 전체게시판 가보면 condition기본 옵션은 제목이라서, 일단 첫 if문에 바로 자동으로 dive됨. 처음 로그인하고 전체목록페이지가 켜지면
			// 그리고, 이떄 '?'파라미터가 없으므로 like '%%'가 돼서 전체조회가 되니까 이전과 똑같이 나옴
			// --> 아니지아니지. 가장 중요한건, GetBoardListController.java의 아래 코드 때문임
				// if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
				// 이게 있으니까, 컨디션없는 경우, 선택하지 않는 경우(처음 로그인할 때 전체게시판 들어가면 condition안 골랐으니 null이잖아)
				// 의 분기처리가 되고, 자연스럽게 위에 tLIst쿼리문이 날라가게 되는 거임
				// wow;;
			// 그런데, 그래도 전체조회도 찾아주자. 내용조건 클릭하고, 빈값으로 검색하면 아무것도 없는게 나와야지 전체조회는 좀 이상해 보임!
				// if(vo.getSearchKeyword() == null) 
				// vo.setSearchKeyword("99999999999999");
				// 원래는 ""부분을 9999999로 해서 웬만하면 포함하는거 없게! - 근데 유한적인 코드..이긴 하네
			System.out.println("키워드!!!!: " + vo.getSearchKeyword());
			
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
