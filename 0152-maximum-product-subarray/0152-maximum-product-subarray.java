class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int globalMax = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];

           
            if (val < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(val, currMax * val);
            currMin = Math.min(val, currMin * val);

            globalMax = Math.max(globalMax, currMax);
        }

        return globalMax;
    }
}