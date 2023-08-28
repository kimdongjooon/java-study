package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		double[] d = new double[a.length];
		
		for (int i = 0 ; i <a.length;i++) {
			d[i] = a[i];
		}
		return d;
	}

	public static int[] doubletoInt(double[] ds) {
		// TODO Auto-generated method stub
		int[] a = new int[ds.length];
		for(int i= 0; i<ds.length; i++) {
			a[i]= (int)ds[i];
		}
		return a;
	}

	public static int[] concate(int[] is, int[] is2) {
		int[] s_array = new int[is.length+is2.length];
		
		for(int i=0 ,j=0 ; j<is2.length&&i<is.length ; i++, j++) {
			s_array[i]=is[i];
			s_array[j+is.length]=is2[j];
		}
	
		return s_array;
	}

}
