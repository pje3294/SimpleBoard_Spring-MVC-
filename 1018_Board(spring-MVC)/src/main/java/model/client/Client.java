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
		vo.setName("����");
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
			// �α��� ����
			System.out.println("�α��� ����!");
		}
		else {
			// �α��� ����
			System.out.println("�α��� ����!");
		}*/
		
		
		factory.close();
	}
}
