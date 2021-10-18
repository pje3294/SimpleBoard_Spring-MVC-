package model.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("clientDAO")
public class ClientDAO {
	/*
	 * private String id; 
	 * private String password; 
	 * private String name; private
	 * String role;
	 * 
	 */

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String insertSQL = "INSERT INTO CLIENT (ID,PASSWORD,NAME) VALUES(?,?,?)";
	private final String updateSQL = "UPDATE CLIENT SET PASSWORD=?, NAME=?, ROLE=? WHERE ID=?";
	private final String deleteSQL = "DELETE FROM CLIENT WHERE ID =?";
	private final String selectAllSQL = "SELECT * FROM CLIENT";
	private final String selectOneSQL = "SELECT * FROM CLIENT WHERE ID=? AND PASSWORD=?";

	public void insertClient(ClientVO vo) {
		System.out.println("insertClient 실행");

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(insertSQL);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

	}

	/////////////////////////////////////////////////////////////////////
	public void updateClient(ClientVO vo) {
		System.out.println("updateClient 실행");

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(updateSQL);

			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

	}

	/////////////////////////////////////////////////////////////////////
	public void deleteClient(ClientVO vo) {
		System.out.println("deleteClient 실행");

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(deleteSQL);

			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}

	}

	/////////////////////////////////////////////////////////////////////
	public List<ClientVO> selectAll(ClientVO vo) {
		System.out.println("selectAll 실행");

		List<ClientVO> datas = new ArrayList<ClientVO>();

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(selectAllSQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ClientVO data = new ClientVO();
				data.setId(rs.getString("ID"));
				data.setName(rs.getString("NAME"));
				data.setPassword(rs.getString("PASSWORD"));
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
	public ClientVO selectOne(ClientVO vo) {
//로그인에 성공한다면, MemberVO 객체가 리턴(반환)
//실패한다면, 리턴이 null
		ClientVO data = null;

		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(selectOneSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				data = new ClientVO();
				data.setId(rs.getString("ID"));
				data.setName(rs.getString("NAME"));
				data.setPassword(rs.getString("PASSWORD"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
}