package model.board2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class BoardRowMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data = new BoardVO();
		data.setId(rs.getInt("ID"));
		data.setTitle(rs.getString("TITLE"));
		data.setContent(rs.getString("CONTENT"));
		data.setWriter(rs.getString("WRITER"));
		data.setWdate(rs.getDate("WDATE"));
		return data;
	}
	
}


// JdbcTemplate ���� ��� 
// 1. extends ��ӹ޾Ƽ� ���� 
// 2. JdbcTemplate�� <bean>���, ������ ���Թ޾� ���  => �ַ� ���!
@Repository() // ���� boardDAO�� ȥ���ɼ� �ֱ� ������ �̸� ���� xx
public class SpringBoardDAO {


	private final String insertSQL = "INSERT INTO BOARD2 (ID,TITLE,WRITER,CONTENT) VALUES((SELECT NVL(MAX(ID),0)+1 FROM BOARD2),?,?,?)";
	private final String updateSQL = "UPDATE BOARD2 SET TITLE=?, CONTENT=? WHERE ID=?";
	private final String deleteSQL = "DELETE FROM BOARD2 WHERE ID =?";
	private final String selectAllSQL = "SELECT * FROM BOARD2 ORDER BY ID DESC";
	private final String selectOneSQL = "SELECT * FROM BOARD2 WHERE ID=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;   //�ܺο��� ���Թ޾� ��� 

	public void insertBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� insert");
		jdbcTemplate.update(insertSQL, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	/////////////////////////////////////////////////////////////////////
	public void updateBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� update");
		jdbcTemplate.update(updateSQL, vo.getTitle(), vo.getContent(), vo.getId());
	}

	/////////////////////////////////////////////////////////////////////
	public void deleteBoard(BoardVO vo) {
		System.out.println("jdbcTemplate���� delete");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}

	/////////////////////////////////////////////////////////////////////
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("jdbcTemplate���� selectAll");
		 return jdbcTemplate.query(selectAllSQL,new BoardRowMapper());
	}

	/////////////////////////////////////////////////////////////////////
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("jdbcTemplate���� selectOne");
		Object[] args= {vo.getId()};
		return jdbcTemplate.queryForObject(selectOneSQL,args, new BoardRowMapper());
		
	}

}
