package ss.week6.threads;

import java.util.concurrent.locks.ReentrantLock;

public class SyncTestConsole implements Runnable {
	
	final static ReentrantLock LOCK = new ReentrantLock();
	
	@Override
	public void run() {
		sum();
	}
	
	private static void sum() {
		LOCK.lock();
		String threadName = Thread.currentThread().getName();
		int num1 = SyncConsole.readInt(threadName + ": get number 1? ");
		int num2 = SyncConsole.readInt(threadName + ": get number 2? ");
		Console.println(threadName + ": " + num1 + " + " + num2 + " = " + (num1 + num2));
		LOCK.unlock();
	}
	
	
	public static void main(String[] args) {
		SyncTestConsole test = new SyncTestConsole();
		new Thread(test, "Thread A").start();
		new Thread(test, "Thread B").start();
	}

}
