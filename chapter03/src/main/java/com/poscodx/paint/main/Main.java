package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
//import com.poscodx.paint.shape.*;
import com.poscodx.paint.text.GraphicText;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10,20);
//		point1.setX(10);
//		point1.setY(20);
		
//		drawPoint(point1);
		draw(point1);
		
//		point1.disappear();
		point1.show(false);
		
//		ColorPoint colorPoint = new ColorPoint();
		Point Point2 = new ColorPoint();
		
		Point2.setX(20);
		Point2.setY(20);
		
		ColorPoint colorPoint = (ColorPoint)Point2; // 다운 캐스팅.
		colorPoint.setColor("red");
		
//		drawPoint(colorPoint);
		draw(colorPoint);
		
		Rect rect = new Rect();
//		drawRect(rect);
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTriangle(triangle);
//		drawShape(triangle);
		draw(triangle);

		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello World"));
		
		//instancof 연산자 Test 
		System.out.println(circle instanceof Circle);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Object);
		// 오류 연산자 instanof 우측항이 클래스인 경우,
		// 레퍼런스 하고 있는class 타임의 hierachy 상의 하위와 상위만 intanceof연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rect);
		
		// 연산자 우측항이 인터페이스 인경우,
		// Hierachy	상관없이 intanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
		
	}
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	
//	public static void drawPoint(Point point) {
//		point.show();
//	}
	
//	public static void drawShape(Shape shape) {
//		shape.draw();
	}
	
//	public static void drawColorPoint(Point colorPoint) {
//		colorPoint.show();
//	}
	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
}
