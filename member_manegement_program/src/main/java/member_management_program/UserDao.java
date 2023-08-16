package member_management_program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 파일에서 List<User>정보를 저장하거나 읽어오는 기능.

public class UserDao {
	// 파일 이름 저장.
	private String filename;
	public UserDao(String filename) {
		this.filename = filename;
	}
	
	// 유저 정보 저장.
	public void saveUser(Iterator<User> iter) {
		List<User> users = new ArrayList<>();
		while(iter.hasNext()) {
			User user = iter.next();
			users.add(user);
		}
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(users);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 유저 정보 가져오기.
	public List<User> getUsers() {
		File file = new File(filename);
		// 저장된 파일이 없으면 빈 리스트 반환.
		if(!file.exists()) {
			return new ArrayList();
		}
		
		// 저장된 파일이 있으면 파일 리스트 반환
		List<User> list = null;
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			list = (List<User>)in.readObject();
		}catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
		return list;
		
		
	}




}
