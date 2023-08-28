package prob05;

public class MyBase extends Base {
	public void service(String state){
		if( state.equals( "낮" ) ) {
			day();
		} else if ( state.equals( "밤" ) ){
			night();
		} else if ( state.equals("오후")){
			pm_day();
		} else {
			System.out.println("올바른 입력값이 아닙니다.");
		}
	}
	
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	public void pm_day(){
		System.out.println("오후에는 낮과 마찬가지고 일해야 합니다.");
	}
	
}
