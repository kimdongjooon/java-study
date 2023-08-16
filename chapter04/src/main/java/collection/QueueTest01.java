package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest01 {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		
		q.offer("둘리");
		q.offer("마이콜");
		q.offer("또치");
		
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		
		System.out.println("===========1");
		
		q.offer("둘리");
		q.offer("마이콜");
		q.offer("또치");
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		// 비어있는 경우 null 반환
		System.out.println(q.poll());
	}

}
