package prob04;

public class StringUtil {
	
	
	public static String concatenate(String[] strArr) {
		String total_str="";
		for (int i = 0 ; i<strArr.length; i++) {
			total_str+=strArr[i];
		}
		return total_str;
	}
}
