package prob03;

import java.util.Objects;

public class Money {
	
	/* 코드 작성 */
	public Money(int i) {
		this.amount = i;
	}

	private int amount;

	public Object add(Money three) {
		
		return new Money(this.amount + three.amount);
	}

	public Object minus(Money two) {
	
		return new Money(this.amount - two.amount);
	}

	public Object multiply(Money two) {
		
		return new Money(this.amount * two.amount);
	}
	
	public Object devide(Money five) {
		
		return new Money(this.amount / five.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj) //이건 무슨 의미? this.equals(obj) 동일성 비교 주소값비교 
//			return true;
//		if (obj == null) //데이터가 없으면 false 반환 
//			return false;
//		if (getClass() != obj.getClass()) // 같은 클래스 타입인지 확인(money타입 확인)
//			return false;
		if (obj instanceof Money) {
			Money other = (Money) obj;
			return amount == other.amount;
		}
		return false;
		
	}
	
	
	
	

	
	
	
}
