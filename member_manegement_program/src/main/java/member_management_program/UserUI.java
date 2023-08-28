package member_management_program;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class UserUI {
	private BufferedReader br;
	// 회원 키보드로 입력 받기
	public UserUI() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// 회원 메뉴. 
	public int menu() {
		System.out.println("1. 회원등록");
		System.out.println("2. 회원목록보기");
		System.out.println("3. 회원정보수정");
		System.out.println("4. 회원정보삭제");
		System.out.println("5. 종료");
		int menuId = 0;
		try {
			String line = br.readLine();
			// 문자열을 정수로 변환;
			menuId = Integer.parseInt(line);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return menuId;
	}
	
	// 유저정보 입력 받기. 
	public User regMenu() {
		try {
			System.out.println("email을 입력하세요.");
			String email = br.readLine();
			System.out.println("이름을 입력하세요.");
			String name = br.readLine();
			System.out.println("생년을 입력하세요.");
			String strbirthYear = br.readLine();
			int birthYear = Integer.parseInt(strbirthYear);
			
			User user = new User(email, name, birthYear);
			return user;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//유저 목록 출력 
	 public void printUserList(Iterator<User> iter) {
		 System.out.println("email         이름          생년");
		 System.out.println("==============================");
		 while(iter.hasNext()) {
			 User user = iter.next();
			 System.out.printf("%s     %s     %d\n",user.getEmail(),user.getName(),user.getBirthYear());
		 }
//		 for(int i = 0 ; i<users.size(); i++) {
//			 User user = users.get(i);
//			 System.out.printf("%s     %s     %d\n",user.getEmail(),user.getName(),user.getBirthYear());					 
//		 }
	 }
	 // 회원 email 입력받는 기능
	 public String inputEmail() {
		 System.out.println("수정할 email을 입력하세요. ");
		 String email = "";
		 try {
			 email = br.readLine();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return email;
	 }
	 
	 // 유저 정보 수정
	 public User updateUser(String email) {
		 // 메일주소가 메모리상의 회원정보에 있을경우
		 try {
				System.out.println(email+"회원 정보를 수정합니다.");
				System.out.println("이름을 입력하세요.");
				String name = br.readLine();
				System.out.println("생년을 입력하세요.");
				String strbirthYear = br.readLine();
				int birthYear = Integer.parseInt(strbirthYear);
				
				User user = new User(email, name, birthYear);
				return user;
			}catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		 
		 // 회원정보가 없을 경우 '수정할 회원정보가 없습니다' 출력.
	 }
	 
	 // 유저 정보 삭제
//	 public User deleteUser(String email) {
		 
//	 }
	
}
