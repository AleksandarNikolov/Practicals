package ss.week6.account;

public class AccountSync {
	
	public static void main(String[] args) {
		Account myAccount = new Account();
		
		Thread one = new Thread(new MyThread(1000.00, 100, myAccount));
		Thread two = new Thread(new MyThread(1000.00, 100, myAccount));
		
		one.start();
		two.start();
		
		System.out.println("Balance: " + myAccount.getBalance());
	}
}
