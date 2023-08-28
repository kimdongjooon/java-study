package tv;

public class TV {
	
	// ***** 코드 재사용 하는 방식으로 최대한 해보기 ****
	private int channel; // 1 ~ 255 255에서 다음으로 클릭시 1번 채널으로
	private int volume; // 0 ~ 100 100이상되면 0으로 로테이션 시키기
	private boolean power; // 켜짐 꺼짐 기능
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public TV() {
		
	}
	
	public int getChannel() {
		return channel;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public boolean isPower() {
		return power;
	}
	
	public void power (boolean on) {
		power = on;
	}
	
	public void channel(int channel) {
		if(power) {
			if(channel >=1 && channel <=255) {
				this.channel = channel;			
			}else {
				this.channel = 255;	
			}
		}else {
			System.out.println("TV가 꺼져 있습니다.");
		}
		

	}
	
	public void channel(boolean up) { //로테 
		if(power) {
			if(up) {
				this.channel++;			
				if(channel>255) {
					this.channel = 1;
				}
			}else {
				this.channel--;
				if(channel>1) {
					this.channel = 255;
				}
			}
		}else {
			System.out.println("TV가 꺼져 있습니다.");
		}
		
	
	}

	public void volume(int volume) {
		if(power) {
			if(volume >=0 && volume <=100) {
				this.volume = volume;			
			}else {
				this.volume = 0;
			}
		}else {
			System.out.println("TV가 꺼져 있습니다.");
		}
		
		
		
	}
	
	public void volume(boolean up) { //로테 
		if(power) {
			if(up) {
				this.volume++;			
				if(volume>100) {
					this.volume = 0;
				}
			}else {
				this.volume--;
				if(volume<0) {
					this.volume = 100;
				}
				
			}
		}else {
			System.out.println("TV가 꺼져 있습니다.");
		}
		
		


	}
	
	
	public void status() {
		System.out.println("TV[power = "+(power ? "on":"off")+", channel = "+channel+", volume = "+volume);
	}
	
}
