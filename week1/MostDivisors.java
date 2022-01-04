package ss.week1;

public class MostDivisors {

    public static void main(String[] args) {
    	
	    int currentDivisor;
	    int testDivisor;
	    int biggestDivisorCount = 0;
	    int currentDivisorCount = 0;
	    int biggestDivisor = 0;
	    
	    for (currentDivisor = 1; currentDivisor <= 10000; currentDivisor++) {
		    for (testDivisor = 1; testDivisor <= currentDivisor; testDivisor++) {
		    	if (currentDivisor % testDivisor == 0) {
		    		currentDivisorCount++;
		    	}
		    }
	    	if (currentDivisorCount > biggestDivisorCount) {
	    		biggestDivisorCount = currentDivisorCount;
	    		biggestDivisor = currentDivisor;
	    	}
	    	currentDivisorCount = 0;
	    }
	    System.out.print("The number is " + biggestDivisor + " having ");
	    System.out.print(biggestDivisorCount + " divisors");
    }
}

