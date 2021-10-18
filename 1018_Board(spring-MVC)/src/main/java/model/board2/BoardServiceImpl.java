package model.board2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService") // ���յ� ����
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SpringBoardDAO boardDAO;
/*	private LogAdvice logAdvice;
	//LogPlusAdvice �� �ٲ��� �Ʒ� �� �ٲ������ --> AOP����, OOP�� ��������! ==> AOP������ ���� �ִ� ����! 
	
	// ������ ���� 
	public BoardServiceImpl() {
		this.logAdvice = new LogAdvice();
	}*/
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		//logAdvice.printLog();
		/*if(vo.getId()==0) {
			throw new IllegalArgumentException(); // ��Ÿ�� ���� (���� �� ����)
		}*/
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//logAdvice.printLog();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//logAdvice.printLog();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		//logAdvice.printLog();
		return boardDAO.selectAll(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {

		return boardDAO.selectOne(vo);
	}

}
