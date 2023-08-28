package prob5;

public class Prob5 {

	public static void main(String[] args) {
	
	
	for(int i = 1 ; i < 100; i++) {
		String s_num = Integer.toString(i);
		String clab = "";
		int correct = 0;
		for (int j = 0 ; j<s_num.length();j++) {
			if(s_num.charAt(j)=='3' || s_num.charAt(j)=='6'||s_num.charAt(j)=='9') {
				clab = clab+"짝";
				correct = 1;
				}
			}
		if (correct==1) {
			System.out.println(s_num+" "+clab);
			}
		}
	
		
	
	}
	
}
