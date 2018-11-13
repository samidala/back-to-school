package Arrays;



import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import arrays.FlattenArrayImpl;



public class FlattenArrayimplTest {

	
	 	int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	 	private final static FlattenArrayImpl flattenArrayImpl = new FlattenArrayImpl();

	 	
	 	@Rule
	 	public ExpectedException expectedException = ExpectedException.none();
	 	
	 	
	    @Test
	    public void testNullObjectReturnsNull() throws IllegalArgumentException {
	        Assert.assertNull(
	                "Testing for null",
	                flattenArrayImpl.flatten(null)
	        );
	    }

	    @Test
	    public void testEmptyObjectArray() throws IllegalArgumentException {
	        Assert.assertArrayEquals(
	                "Testing an array with size 0",
	                new int[]{},
	                flattenArrayImpl.flatten(new Object[]{})
	        );
	    }
	    
	    @Test
	    public void testInternalEmptyObjectArray() throws IllegalArgumentException {
	    	 expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("only flattening integers is supported");
	        Assert.assertArrayEquals(
	                "Testing an array with size 1",
	                new int[]{1},
	                flattenArrayImpl.flatten(new Object[]{new Object[] {"abc"},1})
	        );
	    }

	    @Test
	    public void testFlatObjArray() throws IllegalArgumentException {
	        Assert.assertArrayEquals(
	                "Testing a flat array",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	        );
	    }

	    @Test
	    public void testNestedIntegerArray() throws IllegalArgumentException {
	        Assert.assertArrayEquals(
	                "Testing nested array",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, 3, 4, new Object[]{5, 6, 7, 8}, 9, 10})
	        );
	    }

	    @Test
	    public void testMultipleNestedIntArrays() throws IllegalArgumentException {
	        Assert.assertArrayEquals(
	                "Testing multiple nested arrays",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10})
	        );
	    }

	   @Test
	    public void throwsExceptionForObjectInArray() throws IllegalArgumentException {
	    	 expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("only flattening integers is supported");
	    	flattenArrayImpl.flatten(
	                new Object[]{new Object()}
	        );
	    }

	    @Test
	    public void throwsExceptionForObjectInNestedArray() throws IllegalArgumentException {
	    	 expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("only flattening integers is supported");
	    	
	    	Assert.assertArrayEquals(
	                "Testing multiple nested arrays",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, new Object[]{3, new Object()}})
	        );
	    	
	    }

	    @Test
	    public void throwsExceptionForNullInArray() throws IllegalArgumentException {
	    	 expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("NULL values are not supported");
	    	flattenArrayImpl.flatten(
	                new Object[]{null}
	        );
	    }

	   @Test
	    public void throwsExceptionForNullObjInNestedArray() throws IllegalArgumentException {
	    	expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("NULL values are not supported");
	    	flattenArrayImpl.flatten(
	                new Object[]{1, 2, new Object[]{3, null}}
	        );
	    }
	   
	   @Test
	    public void testMultipleNestedIntArraysWithNull() throws IllegalArgumentException {
		   expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("NULL values are not supported");
	        Assert.assertArrayEquals(
	                "Testing multiple nested arrays for exception",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{null}, 6, 7}, 8, 9, 10})
	        );
	    }
	   
	   @Test
	    public void testMultipleNestedObjArraysWithNullAndNonInt() throws IllegalArgumentException {
		   expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("NULL values are not supported");
	        Assert.assertArrayEquals(
	                "Testing multiple nested arrays for exception",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{null}, "shiva", 7}, 8, 9, 10})
	        );
	    }
	   
	   @Test
	    public void testMultipleNestedObjArraysWithStrings() throws IllegalArgumentException {
		   expectedException.expect(RuntimeException.class);
	    	 expectedException.expectMessage("only flattening integers is supported");
	        Assert.assertArrayEquals(
	                "Testing multiple nested arrays for exception",
	                expectedResult,
	                flattenArrayImpl.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{"shiva"}, 6, 7}, 8, 9, 10})
	        );
	    }
}
