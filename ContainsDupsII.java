package day5;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ContainsDupsII {

	
	@Test
	public void testCase1() {
		int [] nums= {1,2,3,1};
		int k=3;
		boolean containsNearbyDuplicate = containsNearbyDuplicate(nums, k);
		Assert.assertTrue(containsNearbyDuplicate);
	}
	
	
	
	@Test
	public void testCase2() {
		
		int [] nums= {1,0,1,1};
		int k=1;
		boolean containsNearbyDuplicate = containsNearbyDuplicate(nums, k);
		Assert.assertTrue(containsNearbyDuplicate);
	}

	@Test
	public void testCase3() {
		
		int [] nums= {1,2,3,1,2,3};
		int k=2;
		boolean containsNearbyDuplicate = containsNearbyDuplicate(nums, k);
		Assert.assertFalse(containsNearbyDuplicate);
	}
	
	
	
	
	
	/*public boolean containsNearbyDuplicate(int[] nums, int k) {
       Map<Integer, Integer> indices = new HashMap<>();
  for (int i = 0; i < nums.length; i++) {
    Integer lastIndex = indices.put(nums[i], i);
    if (lastIndex != null && (i - lastIndex) <= k)
      return true;
  }
  return false;
 }
	*/
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
}
