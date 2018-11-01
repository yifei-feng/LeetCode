class Solution {
    public int lengthOfLIS(int[] nums) {
        
		int n = nums.length;		
		
		// memory[i]: max length of LIS ending with nums[i]
		int[] memory = new int[n];
		
		// length of LIS for each element of nums should be at least 1 (string is itself)
		Arrays.fill(memory, 1);
		
		//
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(nums[i]>nums[j]){
					memory[i] = Math.max(memory[i], memory[j] + 1);
				}
				
			}
		}
		
		// Find the max length from memory
		int max = 0;
		for(int k=0; k<n; k++){
			max = Math.max(max, memory[k]);
		}
		
		return max;
    }
}
