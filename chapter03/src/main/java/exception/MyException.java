package exception;

public class MyException extends Exception {
	// warnning 해
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}
	
	public MyException() {
		super("MyException Occurs");
	}
}
