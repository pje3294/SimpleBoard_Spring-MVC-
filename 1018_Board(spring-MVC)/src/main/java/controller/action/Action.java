package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//모든 액션은 인풋과 아웃을 가져야함으로 설계상 인터페이스를 쓰는 것이 유용하기 때문에 
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
