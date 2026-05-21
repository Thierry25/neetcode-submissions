class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int total = 1;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                total *= num;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] newArr = new int[nums.length];
        for (int i = 0; i < newArr.length; i++) {
            if (zeroCount > 0) {
                newArr[i] = (nums[i] == 0) ? total : 0;
            } else {
                newArr[i] = total / nums[i];
            }
        }
        return newArr;
    }
}  
