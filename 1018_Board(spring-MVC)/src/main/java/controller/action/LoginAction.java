package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.client.ClientDAO;
import model.client.ClientVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		// 아이디값
		// 비밀번호값
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		// VO에 해당값들을 set 
		ClientVO vo = new ClientVO();
		vo.setId(id);
		vo.setPassword(password);
		
		
		// dao로 getMember() 수행 
		ClientDAO dao = new ClientDAO();
		ClientVO data = dao.selectOne(vo);
		if(data!=null){
			//성공
			System.out.println("로그인성공");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("seClient", vo.getId());
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
			
		}else{
			//실패
			response.sendRedirect("index.jsp");
			
		}
		
		
		
		
		
		
		
		return forward;
	}

}
