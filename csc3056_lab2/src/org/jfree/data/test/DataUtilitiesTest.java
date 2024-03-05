package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
	
	private Values2D values2D;

	@Before
	public void setUp() throws Exception 
	{
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	@After
	public void tearDown() throws Exception 
	{
		values2D = null;
	}

	@Test
	public void testCalculateColumnTotalValidDataAndColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0",
						5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalNullDataColumnTotal() {
		try
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalInvalidNegativeColumnNumber() {
		try
		{
			DataUtilities.calculateColumnTotal(values2D, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalOutOfRangeColumnNumber() {
		try
		{
			DataUtilities.calculateColumnTotal(values2D, 5);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	
	@Test
	public void testCalculateColumnTotalColumnContainingZero() {
		assertEquals("Wrong sum returned. It should be 5.0",
						5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	

	
	@Test
	public void testCalculateColumnTotalValidDataAndColumnTotalWithNegativeNumber() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(4, 0, 0);
		testValues.addValue(1, 1, 0);
		testValues.addValue(5, 0, 1);
		testValues.addValue(-3, 1, 1);
		
		assertEquals("Wrong sum returned. It should be 3.0",
						2.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
	}
	
	// calculateRowTotal
	
	@Test
	public void testCalculateRowTotalValidDataAndRowTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(4, 0, 0);
		testValues.addValue(1, 0, 1);
		testValues.addValue(5, 0, 2);
		testValues.addValue(4, 0, 3);
		
		assertEquals("Wrong sum returned. It should be 14.0",
						10.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalValidDataAndRowTotalWithNegativeValues() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(-4, 0, 0);
		testValues.addValue(-10, 0, 1);
		testValues.addValue(-6, 0, 2);
		testValues.addValue(-13, 0, 3);
		
		assertEquals("Wrong sum returned. It should be 11.0",
						11.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalInvalidNegativeRowNumber() {
		try
		{
			DataUtilities.calculateRowTotal(values2D, -1);
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalOutOfRangeRowNumber() {
		try
		{
			DataUtilities.calculateRowTotal(values2D, -1);
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	// createNumberArray
	
	@Test
	public void testCreateNumberArray() {
		double[] data = new double[] {8.6, 2.0, 14.0, 700.0};
		Number[] expected = new Number[] {8.6, 2.0, 14.0, 700.0};
		Number[] actual = DataUtilities.createNumberArray(data);
		assertArrayEquals("The Expected Array does not match the Actual Array.", expected, actual);
	}
	
	@Test
	public void testCreateNumberArrayWithNegativeValues() {
		double[] data = new double[] {2.0, 7.0, -3.5, 17.0, -20.0};
		Number[] expected = new Number[] {2.0, 7.0, -3.5, 17.0, -20.0};
		Number[] actual = DataUtilities.createNumberArray(data);
		assertArrayEquals("The Expected Array does not match the Actual Array.", expected, actual);
	}
	
	@Test
	public void testCreateNumberArrayWithEmptyArray() {
		double[] data = new double[] {};
		Number[] expected = new Number[] {};
		Number[] actual = DataUtilities.createNumberArray(data);
		assertArrayEquals("The Expected Array does not match the Actual Array.", expected, actual);
	}
	
	@Test
	public void testCreateNumberArrayWithNullValue() {
		try
		{
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	// createNumberArray2D
	
	@Test
	public void testCreateNumberArray2DWithEmptyArray() {
		double[][] data = new double[][] {};
		Number[][] expected = new Number[][] {};
		Number[][] actual = DataUtilities.createNumberArray2D(data);
		assertArrayEquals("The Expected Array does not match the Actual Array.", expected, actual);
	}
	
	@Test
	public void testCreateNumberArray2DWithPositiveValues() {
		double[][] data = new double[][] {{2.0,7.0,10.0}, {13.0,4.0,9.0}};
		Number[][] expected = new Number[][] {{2.0,7.0,10.0}, {13.0,4.0,9.0}};
		Number[][] actual = DataUtilities.createNumberArray2D(data);
		assertEquals("The Expected Array does not match the Actual Array.", expected.length, actual.length);
		
		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals("Row " + i + " does not match expected result", expected[i], actual[i]);
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithNegativeValues() {
		double[][] data = new double[][] {{-2.0,-7.0,-10.0}, {-13.0,-4.0,-9.0}};
		Number[][] expected = new Number[][] {{-2.0,-7.0,-10.0}, {-13.0,-4.0,-9.0}};
		Number[][] actual = DataUtilities.createNumberArray2D(data);
		assertEquals("The Expected Array does not match the Actual Array.", expected.length, actual.length);
		
		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals("Row " + i + " does not match expected result", expected[i], actual[i]);
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithNullValue() {
		try
		{
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DWithArraysOfDifferentLengths() {
		double[][] data = new double[][] {{2.0,7.0},{10.0,13.0},{15.0,4.0}};
		Number[][] expected = new Number[][] {{2.0,7.0},{10.0,13,0}, {15.0,4.0}};
		Number[][] actual = DataUtilities.createNumberArray2D(data);
		assertEquals("The Expected Array does not match the Actual Array.", expected.length, actual.length);
		
		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals("Row " + i + " does not match expected result", expected[i], actual[i]);
		}
	}
	
	
	


}

