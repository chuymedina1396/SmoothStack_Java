package com.ss.JavaBasicsFour;

//Static import because I dropped the actual junit jar file within the lib folder 

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class LineTest {
	Line line;
	@Before
	public void setUp(){
		line = new Line(5,10,15,20);
	}
	@Test
	@DisplayName("Simple calculation of Slope should work") 
	public void getSlope() {
		assertEquals(1, line.getSlope(), .0001);
	}
	
	@Test
	@DisplayName("Simple calculation for getting distance should work")
	public void getDistance() {
		assertEquals(14.142135623730951, line.getDistance(), .0001);
	}
	@Test
	@DisplayName("Simple calculation that determines whether a line is parallel to another")
	public void parallelTo () {
		assertTrue(true == line.parallelTo(line));
	}

}

