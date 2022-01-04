package ss.week3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.hotel.PricedSafe;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";
    
    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;
    

    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    
    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item, 
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getAmount(), 0, 
        		"GetAmount should return the price of the safe.");
    }
    
    @Test
    public void testGetAmount() {
    	assertEquals(safe.getAmount(), PRICE);
    }
    
    @Test
    public void testToString() {
    	assertEquals(safe.toString(), "Safe price: " + PRICE);
    }
    
    @Test
    public void testActivateSafeCorrectPass() {
    	safe.deactivate();
    	safe.activate(CORRECT_PASSWORD);
    	assertTrue(safe.isActive());
    }
    
    @Test
    public void testActiveSafeIncorrectPass() {
    	safe.deactivate();
    	safe.activate(WRONG_PASSWORD);
    	assertFalse(safe.isActive());
    }
    
    @Test
    public void testDeactivatedAndClosedCorrectPass() {
    	safe.open(CORRECT_PASSWORD);
    	assertFalse(safe.isActive());
    	assertFalse(safe.isOpen());	
    }
    
    @Test
    public void testDeactivatedAndClosedIncorrectPass() {
    	safe.open(WRONG_PASSWORD);
    	assertFalse(safe.isActive());
    	assertFalse(safe.isOpen());
    }
    
    @Test
    public void testActivatingAndOpeningSafe() {
    	safe.activate(CORRECT_PASSWORD);
    	safe.open(WRONG_PASSWORD);
    	assertFalse(safe.isOpen());
    	assertTrue(safe.isActive());
    	safe.open(CORRECT_PASSWORD);
    	assertTrue(safe.isOpen());
    	assertTrue(safe.isActive());
    }
    
    @Test
    public void testSafeClosedAndDeactivated() {
    	safe.activate(CORRECT_PASSWORD);
    	safe.open(CORRECT_PASSWORD);
    	safe.close();
    	assertFalse(safe.isOpen());
    	assertTrue(safe.isActive());
    }
    
    @Test
    public void testClosingDeactivatedSafe() {
    	safe.activate(CORRECT_PASSWORD);
    	safe.open(CORRECT_PASSWORD);
    	safe.deactivate();
    	safe.close();
    	assertFalse(safe.isOpen());
    	assertFalse(safe.isActive());
    }
    
}
