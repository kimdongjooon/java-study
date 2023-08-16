package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 날짜 테스트
		Date now = new Date();
		System.out.println(now);
		
		printDate01(now);
		printDate02(now);

	}

	private static void printDate02(Date d) {
		// 년도는 자리 출력하기에 +1900 해야됨.
		int year = d.getYear();
		
		// 월(0 ~ 11) 범위가지며 +1 해야됨.
		int month = d.getMonth();
		
		// 일
		int day = d.getDay();
		
		// 시 
		int hours = d.getHours();
		
		// minute
		int minutes = d.getMinutes();
		
		// second
		int seconds = d.getSeconds();
		
		System.out.println(
				(year+1900) + "-" +
				(month + 1) + "-" +
				day + " " +
				hours + ":" +
				minutes + ":" +
				seconds 
				);
		
	}

	private static void printDate01(Date d) {
		// 2023-08-11 15:00:00 포맷으로 출
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String date = sdf.format(d);
		System.out.println(date);
		
	}

}
