package ss.week2.test;

import ss.week2.ThreeWayLamp;

public class ThreeWayLampTest {
	
	private ThreeWayLamp lampObj;
	
	private void setUp() {
		lampObj = new ThreeWayLamp();
	}
	
	private boolean testDefaultState() {
		return lampObj.getState().equals("OFF");
	}
	
	private boolean testNextState() {
		boolean testNext = true;
		for (int i = 0; i < 4; i++) {
			try {
				lampObj.nextState();
				testNext = true;
			} catch (AssertionError e) {
				testNext = false;
			}
		}
		return testNext;
	}

	
	public static void main(String[] args) {
		ThreeWayLampTest lampTest = new ThreeWayLampTest();
		lampTest.setUp();
		boolean testResult = lampTest.testDefaultState() || lampTest.testNextState();
		if (testResult) {
			System.out.print("Test Passed");
		} else {
			System.out.print("Test Failed");
		}
		
	}
}
