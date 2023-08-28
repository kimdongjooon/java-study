package chapter04;

import java.util.Objects;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}

	// 동질성 오버라이 할때 아래와 같이 해줘야한다...	
	// 해쉬 코드를 먼저 비교한 후에 코드가 같은 경우에 eqauls로 최종적으로 개별 값을 비교한다.
	// 왜 해쉬를 써줘야할까? 일반적으로 많은 변수가 존재할때 해쉬를 사용해서 한번에 비교하는 쪽으로 효율적이기 때문입니다.
	// 그 후 값들간의 내용 비교를 진행하여 동질성 검사를 진행합니다.
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

}
