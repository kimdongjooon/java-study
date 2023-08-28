package prob2;

public class MusicPhone extends Phone {
	public void execute (String funtion) {
		if(funtion.equals("음악")) {
			playMusic();
			return;
		}
		super.execute(funtion);
	}

	private void playMusic() {
		System.out.println("MP3 플레이어에서 음악재생");
	}
}
