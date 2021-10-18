package model.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl implements ClientService{
	

	@Autowired
	private SpringClientDAO clientDAO;
	
	@Override
	public void insertClient(ClientVO vo) {
		clientDAO.insertClient(vo);
	}

	@Override
	public void updateClient(ClientVO vo) {
		clientDAO.updateClient(vo);
	}

	@Override
	public void deleteClient(ClientVO vo) {
		clientDAO.deleteClient(vo);
	}

	@Override
	public List<ClientVO> selectAll(ClientVO vo) {
		return clientDAO.selectAll(vo);
	}

	@Override
	public ClientVO selectOne(ClientVO vo) {
		return clientDAO.selectOne(vo);
	}

}
