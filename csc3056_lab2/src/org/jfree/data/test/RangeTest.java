package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range rangeObjectUnderTest;
	

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-3.5 , 3.5);
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testCentralValueShouldBeZero() {
//		assertEquals("The central value of -1 and 1 should be 0",
//				0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
//	}
	
	// getLowerBound()
	
	@Test
	public void testGetLowerBoundOneNegativeOnePositive() {
		Range r1 = new Range(-5.156,5.837);
		assertEquals("The lower bound value of -5.156 and 5.837 should be -5.156",
				-5.156, r1.getLowerBound(), 0.0000001d);
	}
	
	@Test
	public void testGetLowerBoundBothPositiveAndEqual() {
		Range r2 = new Range(2.0001,2.0001);
		assertEquals("The lower bound value of 2.0001 and 2.0001 should be 2.0001",
				2.0001, r2.getLowerBound(), 0.0000001d);
	}
	
	@Test
	public void testGetLowerBoundBothNegativeAndEqual() {
		Range r3 = new Range(-3.0009,-3.0009);
		assertEquals("The lower bound value of -3.0009 and -3.0009 should be -3.0009",
				-3.0009, r3.getLowerBound(), 0.0000001d);
	}
	
	@Test
	public void testGetLowerBoundBothNegativeAndNotEqual() {
		Range r4 = new Range(-6.2,-4.7);
		assertEquals("The lower bound value of -6.2 and -4.7 should be -6.2",
				-6.2, r4.getLowerBound(), 0.0000001d);
	}
	
	@Test
	public void testGetLowerBoundBothPositiveAndNotEqual() {
		Range r5 = new Range(3.33,9.99);
		assertEquals("The lower bound value of 3.33 and 9.99 should be 3.33",
				3.33, r5.getLowerBound(), 0.0000001d);
	}
	
	@Test
	public void testGetLowerBoundWithZeroAsLowerBound() {
		Range r6 = new Range(0,5.75);
		assertEquals("The lower bound value of 0 and 5.75 should be 0",
				0, r6.getLowerBound(), 0.0000001d);
	}
	
	// getUpperBound()
	
	@Test
	public void testGetUpperBoundOneNegativeOnePositive() {
		Range r7 = new Range(-4.345,4.928);
		assertEquals("The upper bound value of -4.345 and 4.928 should be 4.928",
				4.928, r7.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testGetUpperBoundBothPositiveAndEqual() {
		Range r8 = new Range(6.0002,6.0002);
		assertEquals("The upper bound value of 6.0002 and 6.0002 should be 6.0002",
				6.0002, r8.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testGetUpperBoundBothNegativeAndEqual() {
		Range r9 = new Range(-1.0008,-1.0008);
		assertEquals("The upper bound value of -1.0008 and -1.0008 should be -1.0008",
				-1.0008, r9.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testGetUpperBoundBothNegativeAndNotEqual() {
		Range r10 = new Range(-8.4,-2.1);
		assertEquals("The upper bound value of -8.4 and -2.1 should be -2.1",
				-2.1, r10.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testGetUpperBoundBothPositiveAndNotEqual() {
		Range r11 = new Range(1.88,7.55);
		assertEquals("The upper bound value of 1.88 and 7.55 should be 7.55",
				7.55, r11.getUpperBound(), 0.0000001d);
	}
	
	@Test
	public void testGetUpperBoundWith0AsUpperBound() {
		Range r12 = new Range(-4.69,0);
		assertEquals("The upper bound value of -4.69 and 0 should be 0",
				0, r12.getUpperBound(), 0.0000001d);
	}
	
	// getLength()
	
	@Test
	public void testGetLengthOneNegativeOnePositive() {
		Range r13 = new Range(-3.5,3.5);
		assertEquals("The length of the range -3.5 to 3.5 should be 7",
				7, r13.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r14 = new Range(5.0003,5.0003);
		assertEquals("The length of the range 5.0003 to 5.0003 should be 0",
				0, r14.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthBothPositiveAndNotEqual() {
		Range r15 = new Range(2.2,4.4);
		assertEquals("The length of the range 2.2 to 4.4 should be 2.2",
				2.2, r15.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthBothNegativeAndEqual() {
		Range r16 = new Range(-4.0004,-4.0004);
		assertEquals("The length of the range -4.0004 to -4.0004 should be 0",
				0, r16.getLength(), 0.0000001d);
	}
	
	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		Range r17 = new Range(-7.75,-2.25);
		assertEquals("The length of the range -7.75 to -2.25 should be 5.5",
				5.5, r17.getLength(), 0.0000001d);
	}
	
	// contains()
	
	@Test
	public void testContainsValueAtLowerBound() {
		assertEquals("The range does contain the value -3.5",
				true, rangeObjectUnderTest.contains(-3.5));
	}
	
	@Test
	public void testContainsValueAtUpperBound() {
		assertEquals("The range does contain the value 3.5",
				true, rangeObjectUnderTest.contains(3.5));
	}
	
	@Test
	public void testContainsValueInMiddleOfRange() {
		assertEquals("The range does contain the value 0.5",
				true, rangeObjectUnderTest.contains(0.5));
	}
	
	@Test
	public void testContainsValueOutsideLowerBound() {
		assertEquals("The range does not contain the value -4.1",
				false, rangeObjectUnderTest.contains(-4.1));
	}
	
	@Test
	public void testContainsValueOutsideUpperBound() {
		assertEquals("The range does not contain the value 4.6",
				false, rangeObjectUnderTest.contains(4.6));
	}
	
	// intersects()

	@Test
	public void testIntersectsBothValuesPositivePartiallyOverlapOnUpperBoundary() {
		assertEquals("The range (1,5) does intersect with range (-3,3)",
				true, rangeObjectUnderTest.intersects(1, 5));
	}
	
	@Test
	public void testIntersectsBothValuesNegativePartiallyOverlapOnLowerBoundary() {
		assertEquals("The range (-6,-2) does intersect with range (-3,3)",
				true, rangeObjectUnderTest.intersects(-6, -2));
	}
	
	@Test
	public void testIntersectsOnePositiveOneNegativeInsideTheRange() {
		assertEquals("The range (-1.1,1.1) does intersect with range (-3,3)",
				true, rangeObjectUnderTest.intersects(-1.1, 1.1));
	}
	
	@Test
	public void testIntersectsBothValuesEncloseRange() {
		assertEquals("The range (-4.245,4.894) does intersect with range (-3,3)",
				true, rangeObjectUnderTest.intersects(-4.245, 4.894));
	}
	
	@Test
	public void testIntersectsBothValuesNegativeAndOutsideRangeOnLowerBoundary() {
		assertEquals("The range (-8,-5.44) does not intersect with range (-3,3)",
				false, rangeObjectUnderTest.intersects(-8, -5.44));
	}
	
	@Test
	public void testIntersectsBothValuesPositiveAndOutsideRangeOnUpperBoundary() {
		assertEquals("The range (4.2,6.3) does not intersect with range (-3.5,3.5)",
				false, rangeObjectUnderTest.intersects(4.2, 6.3));
	}
	
	@Test
	public void testIntersectsValuesSameAsRange() {
		assertEquals("The range (-3.5,3.5) does intersect with range (-3.5,3.5)",
				true, rangeObjectUnderTest.intersects(-3.5, 3.5));
	}

}
