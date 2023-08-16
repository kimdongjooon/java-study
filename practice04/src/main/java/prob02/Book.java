package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int bookNo,String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1; 
	}
	
	public void rent() {
		if(stateCode==1) {
			this.stateCode = 0;
			System.out.println(this.title+"이(가) 대여 됐습니다.");
		} else {
			System.out.println(this.title+"이(가) 대여중 입니다.");
		}
	}
	
	public void print() {
		System.out.printf("책 제목:%s, 작가:%s, 대여유무:%s\n",title,author,( stateCode==1 ? "재고있음":"대여중"));
	}
	
	
}
