class Solution {
    public int[] productExceptSelf(int[] nums) {
      int[] newArr = new int[nums.length];
        int k;
        for (int i = 0; i < nums.length; i++) {
            k = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    k *= nums[j];
                }
            }
            newArr[i] = k;
        }
        return newArr;
    }
}  
