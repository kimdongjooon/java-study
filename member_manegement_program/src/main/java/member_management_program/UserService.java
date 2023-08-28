package member_management_program;

import java.util.Iterator;
import java.util.List;

public interface UserService {
	// 회원정보 등록
	public void addUser(User user);

	// 회원정보 수정. 
	// user.getEmail()에 해당하는 회원정보를 수정.
	public boolean updateUser(User user);
	
	// 회원정보 삭제
	public boolean deleteUser(String email);
	
	// 회원정보 출력 
	public Iterator<User> getUsers();
	
	// email에 해당하는 회원정보가 있을 경우 0보다 큰 값을 반 
	public boolean exists(String email);

}
