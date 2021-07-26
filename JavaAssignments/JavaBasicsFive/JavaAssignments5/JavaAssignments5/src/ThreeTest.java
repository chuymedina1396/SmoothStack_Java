import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ThreeTest {
    public static void main(String[] args){
        setUp();
        threeTest();
    }
    @Before
    public static void setUp(){
        Three three = new Three();
    }
	@Test
    public static void threeTest() {
        assertEquals(three.returnListOfStringsWithA();
    }
}



