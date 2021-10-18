package model.client;

import java.util.List;

public interface ClientService {
	void insertClient(ClientVO vo);

	void updateClient(ClientVO vo);

	void deleteClient(ClientVO vo);

	List<ClientVO> selectAll(ClientVO vo);

	ClientVO selectOne(ClientVO vo);
}
