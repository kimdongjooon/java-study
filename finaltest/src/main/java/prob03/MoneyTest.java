package prob03;

public class MoneyTest {

	public static void main(String[] args) {
		Money five = new Money(5);
		Money five_1 = new Money(5);
		Money two = new Money(2);
		Money three = new Money(3);
		Money ten = new Money(10);

		if (five.equals(two.add(three))
				&& three.equals(five.minus(two))
				&& ten.equals(five.multiply(two))
				&& two.equals(ten.devide(five))) {
			System.out.println("Money Class 구현을 완료 하였습니다.");
		}
		
		System.out.println(five);
		System.out.println(five.toString());
		System.out.println(five_1);
		System.out.println(five_1.toString());
		System.out.println(two);
		System.out.println(three);
		System.out.println(ten);
	}
}
