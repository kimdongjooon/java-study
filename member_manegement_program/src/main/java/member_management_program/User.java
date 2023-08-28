package member_management_program;

import java.io.Serializable;

public class User implements Serializable{
	// 인스턴스 필스 
	private String email;
	private String name;
	private int birthYear;
	
	//생성자 (3인자)
	public User(String email, String name, int birthYear) {
		this.email = email;
		this.name = name;
		this.birthYear = birthYear;
	}
	
	//함수
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	
	
	
}
