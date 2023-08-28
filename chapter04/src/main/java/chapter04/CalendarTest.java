package chapter04;

import java.util.Calendar;

public class CalendarTest {
	
	// 메서드는 오버라이드 불가. 클래스는 상속 불가.
	public final void m() {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		// 하나씩 셋팅.
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 11); // 12월(MONTH -1)
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		//한꺼번에 셋팅(년, 월, 일) - 월은 
		cal.set(2022, 10, 23);
		cal.add(Calendar.DATE, 267);
		printDate(cal);

	}
	
	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수","목", "금","토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); //  0~11 반환, +1 해서 사용
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1~7 (일~토)
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				(year) + "-" +
				(month + 1) + "-" +
				date+ " " +
				DAYS[day-1] + "요일 "+
				hour + ":" +
				minute + ":" +
				second 
				);
		
	}

}
