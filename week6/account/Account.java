package ss.week6.account;

public class Account {
	protected double balance = 0.0;

	public synchronized  void transaction(double amount) {
		
		if (balance + amount < -1000.0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		balance = balance + amount;
		//System.out.println(balance);
		notify();
	}
	public double getBalance() {
		return balance;

	}
}
