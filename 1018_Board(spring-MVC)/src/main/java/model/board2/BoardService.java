package model.board2;
// �޼��� in,out ���߱� ���� == �޼��� �ñ״�ó�� ��Ȯ�ϰ� �ϱ����ؼ� 
import java.util.List;

public interface BoardService {

	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	List<BoardVO> selectAll(BoardVO vo);

	BoardVO selectOne(BoardVO vo);
}