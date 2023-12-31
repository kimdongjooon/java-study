package chapter03;

public class Song {
	
	// 필드 
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
		
	
	// 생성자 
	public Song() {} // 기본 생성
	
	public Song(String title, String artist) {
//		this.title = title;
//		this.artist = artist;
		this(title, artist,null,null,0,0);
	}
	
	public Song(String title, String artist, String album, String composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album ;
		this.composer = composer;
		this.year = year;
		this.track = track;
		
		System.out.println(".... some code");
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	
	public void show() {
		System.out.printf("%s %s ( %s, %d, %d번 track, %s 작곡 )\n",artist,title, album, year,track,composer);
	}
	
	
}
