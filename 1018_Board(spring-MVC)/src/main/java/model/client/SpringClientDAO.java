package model.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 매핑을 위한 Client 테이블의 RowMapper 생성
class ClientRowMapper implements RowMapper<ClientVO> {

	@Override
	public ClientVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientVO data = new ClientVO();
		data.setId(rs.getString("ID"));
		data.setName(rs.getString("NAME"));
		data.setPassword(rs.getString("PASSWORD"));
		//data.setRole(rs.getString("ROLE"));
		return data;
	}
}


// // JdbcTemplate 구현 방법 -> 2번  JdbcTemplate을 <bean>등록, 의존성 주입받아 사용 방법사용

@Repository()
public class SpringClientDAO {

	private final String insertSQL = "INSERT INTO CLIENT (ID,PASSWORD,NAME,ROLE) VALUES(?,?,?,?)";
	private final String updateSQL = "UPDATE CLIENT SET PASSWORD=?, NAME=?, ROLE=? WHERE ID=?";
	private final String deleteSQL = "DELETE FROM CLIENT WHERE ID =?";
	private final String selectAllSQL = "SELECT * FROM CLIENT";
	private final String selectOneSQL = "SELECT * FROM CLIENT WHERE ID=? AND PASSWORD=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertClient(ClientVO vo) {
		System.out.println("jdbcTemplate으로 insertClient");
		jdbcTemplate.update(insertSQL, vo.getId(), vo.getPassword(), vo.getName());
		//jdbcTemplate.update(insertSQL, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}

	/////////////////////////////////////////////////////////////////////
	public void updateClient(ClientVO vo) {
		System.out.println("jdbcTemplate으로 updateClient");
		jdbcTemplate.update(updateSQL, vo.getPassword(), vo.getName(), vo.getId());
		//jdbcTemplate.update(updateSQL, vo.getPassword(), vo.getName(), vo.getRole(), vo.getId());
	}

	/////////////////////////////////////////////////////////////////////
	public void deleteClient(ClientVO vo) {
		System.out.println("jdbcTemplate으로 deleteClient");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}

	/////////////////////////////////////////////////////////////////////
	public List<ClientVO> selectAll(ClientVO vo) {
		System.out.println("jdbcTemplate으로 selectAll");
		return jdbcTemplate.query(selectAllSQL, new ClientRowMapper());
	}

	/////////////////////////////////////////////////////////////////////
	public ClientVO selectOne(ClientVO vo) {
//로그인에 성공한다면, MemberVO 객체가 리턴(반환)
//실패한다면, 리턴이 null

		System.out.println("jdbcTemplate으로 selectOne");
		Object[] args = { vo.getId(), vo.getPassword() };
		return jdbcTemplate.queryForObject(selectOneSQL, args, new ClientRowMapper());
	}

}
