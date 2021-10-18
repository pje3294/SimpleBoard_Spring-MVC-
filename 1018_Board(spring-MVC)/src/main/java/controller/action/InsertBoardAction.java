package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board2.BoardDAO;
import model.board2.BoardVO;

public class InsertBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = null;

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setContent(request.getParameter("content"));
		//System.out.println("확인1 : "+request.getParameter("title"));
		//System.out.println("확인2 : "+request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));

		dao.insertBoard(vo);
		

		forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);

		return forward;
	}

}
