package JavaBasicsFour.src;


public class Calculator {
	
	public Integer addition(Integer a, Integer b) {
		if(a==null || b==null) {
			return null;
		}
		return a+b;
	}
	
	public Integer multiply(Integer a, Integer b) {
		if(a==null || b==null) {
			return null;
		}
		return a*b;
	}

}

