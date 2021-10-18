package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board2.BoardDAO;
import model.board2.BoardVO;

public class GetBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();

		String selClient = request.getParameter("selClient");
		//System.out.println("확인1 : "+selClient);

		BoardDAO bdao = new BoardDAO();

		BoardVO vo = new BoardVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		//System.out.println("확인2 : "+Integer.parseInt(request.getParameter("id")));

		BoardVO data = bdao.selectOne(vo);

		request.setAttribute("data", data);
		//System.out.println("data 확인 : "+data);
		request.setAttribute("selClient", selClient);

		forward.setPath("getBoard.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
