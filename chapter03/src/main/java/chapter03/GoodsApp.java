package chapter03;

public class GoodsApp {
	
	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountStock(30);
		camera.setCountSold(50);
		
		
		
		//정보 은닉(데이터 보호) 가능 get, set 메소드를 활용해서. 컨트롤가능.
		camera.setPrice(-1);
		
		// countOfGoods 테스트
		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		Goods tv = new Goods("TV", 4000000, 10, 20);
		tv.showInfo();
		
		
		System.out.println(Goods.countOfGoods);
		
		
		
		camera.setPrice(5000000);
		camera.showInfo();
		
		// 할인 가격 
		int discountPrice = camera.calcDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		
	}

}
