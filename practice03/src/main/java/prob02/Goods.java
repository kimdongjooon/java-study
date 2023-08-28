package prob02;

public class Goods {
	// 필드 선언
	private String name;
	private int price;
	private int stock;
	
	public Goods(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public void showInfo() {
		System.out.printf("%s(가격:%d원)이 %d개 입고 되었습니다.\n",name,price,stock);
	}
	
}
