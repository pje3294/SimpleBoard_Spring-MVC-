package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board2.BoardDAO;
import model.board2.BoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		
		String selClient = request.getParameter("selClient");
		
		BoardDAO bdao = new BoardDAO();
		
		List<BoardVO> datas = bdao.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("selClient", selClient);

		forward.setRedirect(false);
		forward.setPath("main.jsp");
		
		
		return forward;
	}

}
