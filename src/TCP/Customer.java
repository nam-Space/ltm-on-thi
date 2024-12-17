package TCP;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 20170711;
	private int id;
	private String code, name, dayOfBirth, username;
	
	public Customer(int id, String code, String name, String dayOfBirth, String username) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.dayOfBirth = dayOfBirth;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	@Override
	public String toString() {
		return "Customer918 [id=" + id + ", code=" + code + ", name=" + name + ", dayOfBirth=" + dayOfBirth
				+ ", userName=" + username + "]";
	}
}
