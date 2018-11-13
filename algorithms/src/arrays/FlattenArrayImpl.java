package arrays;

import java.util.ArrayList;

import java.util.List;

/**
 * Class to flatten the Array
 * Please note that the input should be sent as array of objects but not int[] or Integer[], though they are still valid values
 * Please refer test cases for examples
 * @author amidala
 *
 */
public class FlattenArrayImpl {
	
	public static void main(String[] args) {
		
		
		
		Object objs[] = new Object[]{1, 2, new Object[]{1,2,3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
		FlattenArrayImpl flattenArrayImpl = new  FlattenArrayImpl();
		List<Integer> flattenList = new ArrayList<>();
		flattenArrayImpl.flatten(objs, flattenList);
		System.out.println(flattenList);
		
		objs =new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10};
		
		flattenList = new ArrayList<>();
		flattenArrayImpl.flatten(objs, flattenList);
		System.out.println(flattenList);
		
		objs =new Object[]{};
		
		flattenList = new ArrayList<>();
		flattenArrayImpl.flatten(objs, flattenList);
		System.out.println(flattenList);
		
	}
	
	/**
	 * Flattens nested array to the int array
	 * @param objs
	 * @return
	 */
	public int[] flatten(Object[] objs) {
		//if objs is null return null
		if(objs == null) {
			return null;
		}
		//objs are empty so returning empty int array
		if(objs.length == 0) {
			return new int[] {};
		}
		//flattenList contains the flattened result of objs
		List<Integer> flattenList = new ArrayList<>();
		
		flatten(objs, flattenList);
		
		//convert list to int array
		return flattenList.stream().mapToInt(i->i).toArray();
	}
	
	/**
	 * recursive flatten function for deeply nested arrays.
	 * @param objs
	 * @param flattenList
	 */
	private void flatten(Object[] objs,List<Integer> flattenList) {
		
		for(Object obj: objs) {
			
			if(obj == null) {
				throw new RuntimeException("NULL values are not supported");
			}else if(obj instanceof Integer) {
				flattenList.add((Integer) obj);
			}else if(obj instanceof Object[] ) {
				flatten((Object[]) obj, flattenList);
			}else {
				throw new RuntimeException("only flattening integers is supported");
			}
			
		}
		
		
	}

}
