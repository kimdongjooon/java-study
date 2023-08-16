package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add( new User( "둘리", "1234") );
		joinUsers.add( new User( "마이콜", "5678") );
		joinUsers.add( new User( "또치", "4321") );
		joinUsers.add( new User( "도우너", "8765") );
		
		System.out.print("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();

		try {
			login(joinUsers, new User( id, password) );
			System.out.println("로그인 성공");
		} catch (UserNotFoundException ex) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		} catch( PasswordDismatchException ex ){
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		} finally {
			scanner.close();
		}
	}
	
	public static void login(List<User> users, User user ) throws UserNotFoundException,PasswordDismatchException{
		if(users.contains(user)) { // 아이디 확인 여부 
			// 유x저 id가 존재할 때
			System.out.println("아이디 확인 완료.");
			int login_success = 0;
			for(int i = 0 ; i < users.size() ; i++) { //비밀번호가 맞을 때
				System.out.println("비밀번호 확인 완료.");
				if(users.get(i).getPassword().equals(user.getPassword())){
					login_success =1;
					break;
				}
			}
			
			if(login_success==0) {
				throw new PasswordDismatchException();
			}
			
			
			
		}else { // 유저 id 없을때
			throw new UserNotFoundException();
		}
		
	}
}
