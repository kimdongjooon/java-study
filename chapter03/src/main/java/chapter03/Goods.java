package chapter03;

public class Goods {

	//필드 변
	public static int countOfGoods = 0;
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	
	public Goods() {
		Goods.countOfGoods++;
	}
	
	
	public Goods(String name, int price, int countStock, int countSold) {
		this.name = name;
		this.price = price;
		this.countStock = countStock;
		this.countSold = countSold;
		Goods.countOfGoods++;
	}


	public void showInfo() {
		System.out.println("!!!!상품 이름은 "+ getName());
		System.out.println("가격은 "+ getPrice());
		System.out.println("재고개수는 "+ getCountStock());
		System.out.println("팔린개수는 "+ getCountSold());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price <0) {
			this.price = 0;
		}else {
			this.price = price;
		}
		
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}


	public int calcDiscountPrice(double discountRate) {
		
		return (int)(price * discountRate);
	}
	
	

}
