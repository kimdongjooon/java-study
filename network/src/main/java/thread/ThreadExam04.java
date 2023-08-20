package thread;

public class ThreadExam04 {

	public static void main(String[] args) {
		String name = Thread.currentThread().getName();
		System.out.println("thread name : "+name);
		
		Thread thread01 = new StrThread("*");
		Thread thread02 = new StrThread("+");
		
		thread01.start();
		thread02.start();
		
		System.out.println("main thread end!");

	}

}
