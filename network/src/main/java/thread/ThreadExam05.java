package thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadExam05 {

	public static void main(String[] args) {
		// 서브 스레드가 다 실핼될때 까지 메인 스레드를 유지 시키기
		List<Thread> arrayThread = new ArrayList<>();
		
		String name = Thread.currentThread().getName();
		System.out.println(name +" thread start!");
		
		Thread thread01 = new StrThread("*");
		Thread thread02 = new StrThread("+");
		arrayThread.add(thread01);
		arrayThread.add(thread02);
		
		for (int i = 0; i<arrayThread.size(); i++) {
			arrayThread.get(i).start();
			try {
				arrayThread.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		System.out.println("\n"+name+" thread end!");

	}

}
