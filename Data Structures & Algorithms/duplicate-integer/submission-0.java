class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        
        boolean result = false;
        for (var value : map.values()) {
            if (value > 1) {
                result = true;
            }
        }
        return result;
    }
}