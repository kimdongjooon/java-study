package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		// 작은 수를 오른쪽으로 변경
		// 총 길이의 -1번 만큼 스왑해야됨.
		for (int i = 0 ; i < array.length-1 ; i++) { 
			
			// 스왑할때마다 맨 오른쪽은 제일 작은 수이므로 비교 횟수 1번씩 감소.
			for (int j = 0 ; j < array.length-1-i ; j++) { 
				int temp_num = array[j];
				if(array[j]<array[j+1]) { // 작은 수 오른쪽으로 이동.
					array[j] = array[j+1];
					array[j+1]= temp_num;
				}
			}
		}
		

		
		// 결과 출력
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		
	}
}