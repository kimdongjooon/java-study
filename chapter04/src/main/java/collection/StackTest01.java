package collection;

import java.util.Stack;

public class StackTest01 {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");
		
		while(!s.empty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// 비어 있는 경우에는 예외 발생.
		// s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");
		
		System.out.println(s.pop());
		System.out.println(s.peek()); // 뻬내지 않고 제일 위에 쌓은거 보기.
		System.out.println(s.pop());
	}

}
