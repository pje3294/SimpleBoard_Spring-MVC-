package model.client;

/*
	id varchar(15) primary key,
	password varchar(15),
	name varchar(15),
	role varchar(15)
)
 * */

public class ClientVO {
	private String id;
	private String password;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passward) {
		this.password = passward;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", password=" + password + ", name=" + name + "]";
	}

}
