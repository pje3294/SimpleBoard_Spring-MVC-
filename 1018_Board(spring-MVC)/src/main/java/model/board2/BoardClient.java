package model.board2;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		BoardService bs = (BoardService) factory.getBean("boardService");

		BoardVO vo = new BoardVO();
		/*vo.setContent("오늘의 글");
		vo.setTitle("10월 11일");
		vo.setWriter("관리자");
		bs.insertBoard(vo);*/
		
		List<BoardVO> datas = bs.selectAll(vo);
		for(BoardVO data : datas) {
			System.out.println(data);
		}
		
		factory.close();
	}

}
