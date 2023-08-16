package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void show() {
//		super.show();
		System.out.printf("점 [x=%d,y=%d,color=%s]을 그렸습니다.\n", x,this.getY(),color);
		
	}
	
	@Override
//	public void m() {} 아예 없으면 에러남 오버라이트 어노테이션을 명시할때 한번 부모 클래스에 메소드 있는지 확인함.
	
	public void disappear() {
		System.out.printf("점 [x=%d,y=%d,color=%s]을 지웠습니다.\n", getX(),getY(),color);
		
	}
	
	
}
