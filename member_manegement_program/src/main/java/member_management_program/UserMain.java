package member_management_program;

import java.util.List;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserUI userUI = new UserUI();
		UserDao userDao = new UserDao("users.dat");
//		List<User> users = UserDao.getUser();
		UserService userService = new UserServiceInMemory(userDao.getUsers());
		
		while(true) {
			int menuId = userUI.menu();
			if(menuId == 5) {
				System.out.println("종료합니다.");
				userDao.saveUser(userService.getUsers());
				break;
			}else if(menuId == 1) {
				User user = userUI.regMenu();
//				users.add(user);
				userService.addUser(user);
				System.out.println("등록되었습니다.");
			}else if(menuId == 2) {
				userUI.printUserList(userService.getUsers());
			}else if(menuId == 3) {
				String email = userUI.inputEmail();
				boolean isFindEmail = userService.exists(email);
				
//				int findIndex = -1;
//				for (int i = 0 ;i < users.size(); i++) {
//					User u = users.get(i);
//					if(u.getEmail().equals(email)) {
//						findIndex = i;
//						break;
//					}
//				}
				
				if(isFindEmail) {
					User updateUser = userUI.updateUser(email);
					userService.updateUser(updateUser);
//					users.remove(findIndex);
//					users.add(updateUser);
					System.out.println("수정되었습니다.");
					
				}else {
					System.out.println("수정할 회원 정보가 없습니다.");
				}

			}else if(menuId == 4) {
				String email = userUI.inputEmail();
				boolean isFindEmail = userService.exists(email);
//				int findIndex = -1;
//				for (int i = 0 ;i < users.size(); i++) {
//					User u = users.get(i);
//					if(u.getEmail().equals(email)) {
//						findIndex = i;
//						break;
//					}
//				}
				
				if(isFindEmail) {
//					users.remove(findIndex);
					userService.deleteUser(email);
					System.out.println("삭제되었습니다.");
					
				}else {
					System.out.println("삭제할 회원 정보가 없습니다.");
				}
			}
			
			else {
				System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
			}
		}
	}

}
