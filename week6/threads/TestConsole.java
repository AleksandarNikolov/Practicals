package ss.week6.threads;

public class TestConsole implements Runnable{

	@Override
	public void run() {
		sum();
	}
	
	private void sum() {
		String threadName = Thread.currentThread().getName();
		int num1 = Console.readInt(threadName + ": get number 1? ");
		int num2 = Console.readInt(threadName + ": get number 2? ");
		Console.println(threadName + ": " + num1 + " + " + num2 + " = " + (num1 + num2));
	}
	
	
	public static void main(String[] args) {
		new Thread(new TestConsole(), "Thread A").start();
		new Thread(new TestConsole(), "Thread B").start();
	}

}
