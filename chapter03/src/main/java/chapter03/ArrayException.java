package chapter03;

public class ArrayException {

	public static void main(String[] args) {
		int[] intArray = new int[5];
		intArray[0] = 0;
		
		try {
			for (int i = 0 ; i <intArray.length; i++) {
				intArray[i+1] = i + 1 + intArray[i];
				System.out.println("intArray["+ i + "] = "+intArray[i]);
			}			
		}catch ( ArrayIndexOutOfBoundsException e) {
			//배열 인덱스 벗어난 에러. 
			//for 문에서 i 가 4일때 intArray의 배열이 인덱스가 4까진에 5에 접근하는 인덱스 에러 발생.
			e.printStackTrace();
		}


	}

}
