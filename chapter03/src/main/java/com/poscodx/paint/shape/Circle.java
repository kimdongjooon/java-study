package com.poscodx.paint.shape;

public class Circle extends Shape{
	
	private int x1, x2;
	private int radius;
	
	@Override
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
}
