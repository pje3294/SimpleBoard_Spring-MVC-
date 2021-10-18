package model.board2;
// 메서드 in,out 맞추기 위해 == 메서드 시그니처를 정확하게 하기위해서 
import java.util.List;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	List<BoardVO> selectAll(BoardVO vo);

	BoardVO selectOne(BoardVO vo);
}