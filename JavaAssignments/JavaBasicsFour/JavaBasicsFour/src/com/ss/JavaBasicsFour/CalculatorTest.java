package com.ss.JavaBasicsFour;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CalculatorTest {
	
	Calculator cal = new Calculator(); 
	
	@Test
	public void additionTest() {
		assertEquals(4, cal.addition(2, 2), .0001);
		assertNotEquals(4, cal.addition(2, 3), .0001);
		assertNull(cal.addition(null, 2));
		assertNull(cal.addition(2, null));
	}
	
	@Test
	public void multiplyTest() {
		assertEquals(4, cal.multiply(2, 2), .0001);
		assertNotEquals(4, cal.multiply(2, 3), .0001);
		assertNull(cal.multiply(null, 2));
		assertNull(cal.multiply(2, null));
	}

}


