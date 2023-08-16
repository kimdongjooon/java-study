package prob2;

public class Phone {
	public void execute( String function ) {
		call(function);
	}
	
	private void call(String function){
		if("통화".equals(function)) {
			System.out.println( "통화기능시작" );			
		}
		if("앱".equals(function)) {
			System.out.println("앱시작" );			
		}
		if("음악".equals(function)) {
			System.out.println("다운로드해서 음악재생" );
		}

	}
}
