package ss.week6.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	private final Lock lock = new ReentrantLock();
	private final Condition isWritten = lock.newCondition();
	private final Condition isRead = lock.newCondition();
	private boolean newValue = false;
	private int value = 0;

	public void setValue(int valueArg) {
		lock.lock();
		
		while (newValue) {
			try {
				isWritten.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		value = valueArg;
		newValue = true;
		isRead.signal();
		
		lock.unlock();
		
	}


	public int getValue() {
		int readValue;
		
		lock.lock();
		
		while (!newValue) {
			try {
				isRead.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		readValue = value;
		newValue = false;
		isWritten.signal();
		
		lock.unlock();
		
		return readValue;
	}
}
