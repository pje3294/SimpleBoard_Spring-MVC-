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
		
		// ���̵�
		// ��й�ȣ��
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		// VO�� �ش簪���� set 
		ClientVO vo = new ClientVO();
		vo.setId(id);
		vo.setPassword(password);
		
		
		// dao�� getMember() ���� 
		ClientDAO dao = new ClientDAO();
		ClientVO data = dao.selectOne(vo);
		if(data!=null){
			//����
			System.out.println("�α��μ���");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("seClient", vo.getId());
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
			
		}else{
			//����
			response.sendRedirect("index.jsp");
			
		}
		
		
		
		
		
		
		
		return forward;
	}

}
