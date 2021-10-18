package model.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Client {
	public static void main(String[] args) {
AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		
	ClientService cs = (ClientService) factory.getBean("clientService");

		ClientVO vo = new ClientVO();
		/*vo.setId("apple");
		vo.setName("애플");
		vo.setPassword("pw");
		vo.setRole("USER");
		
		cs.insertClient(vo);*/
		
		
		List<ClientVO> datas = cs.selectAll(vo);
		for(ClientVO data : datas) {
			System.out.println(data);
		}
		
		
		/*vo.setId("admin");
		vo.setPassword("1234");
		
		ClientVO data = cs.selectOne(vo);
		
		if(data!=null) {
			// 로그인 성공
			System.out.println("로그인 성공!");
		}
		else {
			// 로그인 실패
			System.out.println("로그인 실패!");
		}*/
		
		
		factory.close();
	}
}
