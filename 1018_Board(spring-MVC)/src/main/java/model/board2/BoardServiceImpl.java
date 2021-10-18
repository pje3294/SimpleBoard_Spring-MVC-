package model.board2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService") // 결합도 낮춤
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SpringBoardDAO boardDAO;
/*	private LogAdvice logAdvice;
	//LogPlusAdvice 로 바뀔경우 아래 다 바꿔줘야함 --> AOP지만, OOP가 섞여있음! ==> AOP설정이 따로 있는 이유! 
	
	// 생성자 주입 
	public BoardServiceImpl() {
		this.logAdvice = new LogAdvice();
	}*/
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		//logAdvice.printLog();
		/*if(vo.getId()==0) {
			throw new IllegalArgumentException(); // 런타임 에러 (실행 시 에러)
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
