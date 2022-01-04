package ss.week1;

public class MostDivisorsWithArray {

    public static void main(String[] args) {
    	
	    int currentDivisor;
	    int testDivisor;
	    int biggestDivisorCount = 0;
	    int currentDivisorCount = 0;
	    int[] arrayDivisors = new int[10001];
	    
	    for (currentDivisor = 1; currentDivisor <= 10000; currentDivisor++) {
		    for (testDivisor = 1; testDivisor <= currentDivisor; testDivisor++) {
		    	if (currentDivisor % testDivisor == 0) {
		    		currentDivisorCount++;
		    	}
		    }
	    	if (currentDivisorCount > biggestDivisorCount) {
	    		biggestDivisorCount = currentDivisorCount;
	    	}
	    	
	    	arrayDivisors[currentDivisor] = currentDivisorCount;
	    	
	    	currentDivisorCount = 0;
	    }
	    
	    System.out.println("Among integers between 1 and 10000");
	    System.out.println("The maximum number of divisors was " + biggestDivisorCount);
	    System.out.println("Numbers with that many divisors include:");
	    
	    int i;
	    for (i = 1; i < arrayDivisors.length; i++) {
	    	if (arrayDivisors[i] == biggestDivisorCount) {
	    		System.out.println("	" + i);
	    	}
	    }
	    
    }
	
}
