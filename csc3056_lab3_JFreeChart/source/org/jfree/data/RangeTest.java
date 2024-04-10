package org.jfree.data;

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
	
	
	// expandToInclude()
	
	@Test
	public void testExpandToIncludeWithNullRange() {
		Range r13 = Range.expandToInclude(null, 4);
		assertEquals("Expected range to be 4 to 4",
				new Range(4,4), r13);
	}
		
	@Test
	public void testExpandToIncludeValueInsideRange() {
		Range r14 = Range.expandToInclude(new Range(1.345,6.789), 3.126);
		assertEquals("Expected range to be 1.345 to 6.789",
				new Range(1.345,6.789), r14);
	}
		
	@Test
	public void testExpandToIncludeValueBelowRange() {
		Range r15 = Range.expandToInclude(new Range(0.0,8.6), -3.2);
		assertEquals("Expected range to be -3.2 to 8.6",
				new Range(-3.2,8.6), r15);
	}
		
	@Test
	public void testExpandToIncludeValueAboveRange() {
		Range r16 = Range.expandToInclude(new Range(8.88,14.14), 19.19);
		assertEquals("Expected range to be 8.88 to 19.19",
				new Range(8.88,19.19), r16);
	}
		
	@Test
	public void testExpandToIncludeValueEqualsLowerBound() {
		Range r17 = Range.expandToInclude(new Range(1.1,7), 1.1);
		assertEquals("Expected range to be 1.1 to 7",
				new Range(1.1,7), r17);
	}
		
	@Test
	public void testExpandToIncludeValueEqualsUpperBound() {
		Range r18 = Range.expandToInclude(new Range(-3,6.8), 6.8);
		assertEquals("Expected range to be -3 to 6.8",
				new Range(-3,6.8), r18);
	}
	
	
	// constrain
	
	@Test
	public void testConstrainsValueOnLowerBoundary() {
		assertEquals("The closest value to -3.5 in the range (-3.5,3.5) is -3.5",
				-3.5, rangeObjectUnderTest.constrain(-3.5), 0.0000001d);
	}
	
	@Test
	public void testConstrainsValueOnUpperBoundary() {
		assertEquals("The closest value to 3.5 in the range (-3.5,3.5) is 3.5",
				3.5, rangeObjectUnderTest.constrain(3.5), 0.0000001d);
	}
	
	@Test
	public void testConstrainPositiveValueInsideTheRange() {
		assertEquals("The closest value to 0.5 in the range (-3.5,3.5) is 0.5",
				0.5, rangeObjectUnderTest.constrain(0.5), 0.0000001d);
	}
	
	@Test
	public void testConstrainNegativeValueInsideTheRange() {
		assertEquals("The closest value to -1.234 in the range (-3.5,3.5) is -1.234",
				-1.234, rangeObjectUnderTest.constrain(-1.234), 0.0000001d);
	}
	
	@Test
	public void testConstrainValueOutsideRangeBelowLowerBoundary() {
		assertEquals("The closest value to -4.1 in the range (-3.5,3.5) is -3.5",
				-3.5, rangeObjectUnderTest.constrain(-4.1), 0.0000001d);
	}
	
	@Test
	public void testConstrainValueOutsideRangeAboveUpperBoundary() {
		assertEquals("The closest value to 4.6 in the range (-3.5,3.5) is 3.5",
				3.5, rangeObjectUnderTest.constrain(4.6), 0.0000001d);
	}
	
	//Added to try and trigger missed branch
	@Test
	public void testConstrainValueBelowLowerBoundary() {
	    assertEquals("The closest value to -5.0 in the range (-3.5,3.5) is -3.5",
	            -3.5, rangeObjectUnderTest.constrain(-5.0), 0.0000001d);
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
	
	@Test
	public void testIntersectsBothValuesNegativeAndInsideRangeOnUpperBoundary() {
	    assertEquals("The range (-3.3, 2.7) does intersect with range (-3.5,3.5)",
	            true, rangeObjectUnderTest.intersects(-3.3, 2.7));
	}
	
	
	// getLength
	
	@Test
    public void testGetLengthPositiveBounds() {
        assertEquals("Length of range (0, 5) should be 5.0", 5.0, rangeObjectUnderTest.getLength(), 0.0000001);
    }
	
	//getCentralValue
	
	@Test
    public void testGetCentralValuePositiveBounds() {
        assertEquals("Central value of range (0, 5) should be 2.5", 2.5, rangeObjectUnderTest.getCentralValue(), 0.0000001);
    }
	
	//Expand 
	
	 @Test
	    public void testExpandNonNullRange() {
	        Range expandedRange = Range.expand(rangeObjectUnderTest, 0.1, 0.1);
	        assertEquals("Expanded range lower bound should be -4.9", -4.9, expandedRange.getLowerBound(), 0.0000001);
	        assertEquals("Expanded range upper bound should be 4.9", 4.9, expandedRange.getUpperBound(), 0.0000001);
	    }
	 
	 @Test
	    public void testExpandWithNullRange() {
	        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
	            Range.expand(null, 0.1, 0.1);
	        });
	        assertEquals("Exception message should match", "Null 'range' argument.", exception.getMessage());
	    }
	 
	 //combine
	 
	 @Test
	    public void testCombineBothNonNullRanges() {
	        Range range1 = new Range(-2.0, 2.0);
	        Range range2 = new Range(-1.0, 3.0);
	        Range combinedRange = Range.combine(range1, range2);
	        assertEquals("Combined range lower bound should be -2.0", -2.0, combinedRange.getLowerBound(), 0.0000001);
	        assertEquals("Combined range upper bound should be 3.0", 3.0, combinedRange.getUpperBound(), 0.0000001);
	    }

	    @Test
	    public void testCombineFirstRangeNull() {
	        Range range2 = new Range(-1.0, 3.0);
	        Range combinedRange = Range.combine(null, range2);
	        assertEquals("Combined range lower bound should be -1.0", -1.0, combinedRange.getLowerBound(), 0.0000001);
	        assertEquals("Combined range upper bound should be 3.0", 3.0, combinedRange.getUpperBound(), 0.0000001);
	    }

	   
	    @Test
	    public void testCombineBothRangesNull() {
	        Range combinedRange = Range.combine(null, null);
	        assertEquals("Combined range should be null", null, combinedRange);
	    }
	    
	    @Test
	    public void testCombineWithFirstNotNullAndSecondNull() {
	        Range range1 = new Range(1.0, 5.0);
	        Range range2 = null;
	        Range result = Range.combine(range1, range2);
	        assertNull("The result should be null when the second range is null", result);
	    }
	    
	    
	    //hashCode
	    
	    @Test
	    public void testHashCode() {
	        int expectedHashCode = rangeObjectUnderTest.hashCode();
	        assertEquals("Hash code should not be zero", 1, expectedHashCode);
	    }
	    
	    //toString
	    
	    @Test
	    public void testToString() {
	        String expectedToString = "Range[-3.5,3.5]";
	        String actualToString = rangeObjectUnderTest.toString();
	        assertEquals("Generated toString representation should match", expectedToString, actualToString);
	    }
	    
	    //range
	    
	    @Test
	    public void testRangeValidBounds() {
	        assertEquals("Lower bound should be -3.5", -3.5, rangeObjectUnderTest.getLowerBound(), 0.0000001);
	        assertEquals("Upper bound should be 3.5", 3.5, rangeObjectUnderTest.getUpperBound(), 0.0000001);
	    }

	    @Test
	    public void testRangeEqualBounds() {
	        assertEquals("Lower bound should be 2.0", 2.0, rangeObjectUnderTest.getLowerBound(), 0.0000001);
	        assertEquals("Upper bound should be 2.0", 2.0, rangeObjectUnderTest.getUpperBound(), 0.0000001);
	    }

	    @Test
	    public void testRangeInvalidBounds() {
	        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
	            new Range(3.0, 2.0);
	        });
	        assertEquals("Exception message should match", "Range(double, double): require lower (3.0) <= upper (2.0).", exception.getMessage());
	    }
	    
	    //Shift 
	    
	    @Test
	    public void testShiftAllowZeroCrossingTrue() {
	        Range shiftedRange = Range.shift(rangeObjectUnderTest, 2.0, true);
	        assertEquals("Lower bound should be -1.5", -1.5, shiftedRange.getLowerBound(), 0.0000001);
	        assertEquals("Upper bound should be 5.5", 5.5, shiftedRange.getUpperBound(), 0.0000001);
	    }

	    @Test
	    public void testShiftAllowZeroCrossingFalse() {
	        Range shiftedRange = Range.shift(rangeObjectUnderTest, 2.0, false);
	        assertEquals("Lower bound should be -1.5", -1.5, shiftedRange.getLowerBound(), 0.0000001);
	        assertEquals("Upper bound should be 5.5", 5.5, shiftedRange.getUpperBound(), 0.0000001);
	    }

	   
	}

