package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
//		int[] a = {10, 20, 30, 40}; // new int[] 생략 
		
		double[] d = ArrayUtil.intToDouble(new int[]{10, 20, 30, 40});
		
		
//		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(d));
		
		
		
		int[] a1 = ArrayUtil.doubletoInt(new double[] {10.0, 12.0, 13.0});
		System.out.println(Arrays.toString(a1));
		
		int[] a2 = ArrayUtil.concate(new int[] {1,2,3}, new int[] {4,5,6});
		System.out.println(Arrays.toString(a2));
		
		
	}

}
