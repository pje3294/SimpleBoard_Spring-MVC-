package model.board2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// JDBC 
// DAO -> 드라이버, CP, MyBatis, JPA....
// Service를  DAO 객체를 이용하여  CRUD기능을 제공할 예정
// ex> 폰 Service <-> 시계 DAO 

@Repository("boardDAO")  //@Compenent 상속받은 레포지토리 
public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String insertSQL = "INSERT INTO BOARD2 (ID,TITLE,WRITER,CONTENT) VALUES((SELECT NVL(MAX(ID),0)+1 FROM BOARD2),?,?,?)";
	private final String updateSQL = "UPDATE BOARD2 SET TITLE=?, CONTENT=? WHERE ID=?";
	private final String deleteSQL = "DELETE FROM BOARD2 WHERE ID =?";
	private final String selectAllSQL = "SELECT * FROM BOARD2 ORDER BY ID DESC";
	private final String selectOneSQL = "SELECT * FROM BOARD2 WHERE ID=?";

	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard 실행");

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(insertSQL);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

	}

	/////////////////////////////////////////////////////////////////////
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard 실행");

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(updateSQL);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());

			pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

		//return result;
	}

	/////////////////////////////////////////////////////////////////////	
	public void deleteBoard(BoardVO vo) {
		conn = JDBC.getConnection();
		//boolean result = false;

		try {
			pstmt = conn.prepareStatement(deleteSQL);

			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();

			//result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

		//return result;
	}
	
	/////////////////////////////////////////////////////////////////////
	public List<BoardVO> selectAll() {
		System.out.println("selectAll 실행");

		List<BoardVO> datas = new ArrayList<BoardVO>();

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(selectAllSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setId(rs.getInt("ID"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				data.setWdate(rs.getDate("WDATE"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}

		return datas;
	}
	
	/////////////////////////////////////////////////////////////////////
	public BoardVO selectOne(BoardVO vo) {
		conn = JDBC.getConnection();
		BoardVO data = null;
		
		try {
			pstmt = conn.prepareStatement(selectOneSQL);
			pstmt.setInt(1, vo.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data = new BoardVO();
				data.setId(rs.getInt("ID"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				data.setWdate(rs.getDate("WDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}

}
