package thread;

public class StrThread extends Thread {
	private String str;
	
	public StrThread (String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10 ; i++) {
			System.out.print(str);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
			
}
