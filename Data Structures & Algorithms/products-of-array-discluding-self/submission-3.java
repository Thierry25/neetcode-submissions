class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCount = 0;

        for (var num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                total *= num;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                result[i] = (nums[i] == 0) ? total : 0;
            } else {
                result[i] = total / nums[i];
            }
        }
        return result;
    }
}  
