package ss.utils;


class Main {
	public static void main(String[] args) {
		Ferrari ferrari = new Ferrari();
		ferrari.type();
		ferrari.kod();
	}
}

abstract class Car {
	public void type() {
		System.out.println("Kola");
	}
	
	
}

class Ferrari extends Car {
	public void kod() {
		System.out.println("kod");
	}
	
	
}