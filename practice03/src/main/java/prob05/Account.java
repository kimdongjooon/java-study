package prob05;

public class Account {

	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.printf("%s계좌가 개설되었습니다.\n",accountNo);
	}
	
	public void save(int money) {
		this.balance += money;
		System.out.printf("%s계좌에 %d만원이 입금되었습니다.\n",accountNo,balance);
	}
	
	public void deposit(int money) {
		if(this.balance - money < 0) {
			System.out.println("잔고가 부족합니다.");
		}else {
			this.balance -= money;
			System.out.printf("%s계좌에 %d만원이 출금되었습니다.\n",accountNo,money);
		}
		
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	
}
