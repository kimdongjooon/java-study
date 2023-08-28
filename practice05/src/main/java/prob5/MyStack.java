package prob5;

public class MyStack {

	private String[] buffer;
	
	private static int top = 0;
	private int index;
	
	public MyStack(int i) {
		this.index = i;
		set_MyStack(index);
	}
	
	public void set_MyStack(int index) {
		buffer = new String[index];
	}

	public void push(String string) {
		// 배열이 다차면 크기가 2배가 되는 배열 다시 선언 후 복사하기 
		if(top >= buffer.length) {
			// 기존 배열 복사해놓기
			String[] temp_buffer = new String[buffer.length*2];
			for (int j = 0; j < buffer.length;j++) {
				temp_buffer[j] = buffer[j];
			}
			// 새로운 버퍼 선언 
			buffer = temp_buffer;
			buffer[top] = string;
			top++;
			
			
		}else {
			buffer[top] = string;
			top++;
			
		}
		
		
	}
	
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}else {
			return false;			
		}

	}

	public String pop() throws MyStackException{
		if(isEmpty()) {
			throw new MyStackException();
		}
		top--;
		String pop_str = buffer[top];
		return pop_str;
	}
	
	
}