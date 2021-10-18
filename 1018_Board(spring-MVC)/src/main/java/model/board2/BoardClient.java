package model.board2;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService bs = (BoardService) factory.getBean("boardService");

		BoardVO vo = new BoardVO();
		/*vo.setContent("������ ��");
		vo.setTitle("10�� 11��");
		vo.setWriter("������");
		bs.insertBoard(vo);*/
		
		List<BoardVO> datas = bs.selectAll(vo);
		for(BoardVO data : datas) {
			System.out.println(data);
		}
		
		factory.close();
	}

}
