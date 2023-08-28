package thread;

public class ThreadExam02 {

	public static void main(String[] args) {
		Thread thread01 = new DigitalThread();
		Thread thread02 = new AlphabetThread();
		
		thread01.start();
		thread02.start();
	}

}
