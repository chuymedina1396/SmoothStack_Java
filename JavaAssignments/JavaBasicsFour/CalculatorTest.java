import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CalculatorTest {
	
	Calculator cal = new Calculator(); 
	
	@Test
	public void additionTest() {
		assertEquals(new Integer(4), cal.addition(2, 2));
		assertNotEquals(new Integer(4), cal.addition(2, 3));
		assertNull(cal.addition(null, 2));
		assertNull(cal.addition(2, null));
	}
	
	@Test
	public void multiplyTest() {
		assertEquals(new Integer(4), cal.multiply(2, 2));
		assertNotEquals(new Integer(4), cal.multiply(2, 3));
		assertNull(cal.multiply(null, 2));
		assertNull(cal.multiply(2, null));
	}

}


