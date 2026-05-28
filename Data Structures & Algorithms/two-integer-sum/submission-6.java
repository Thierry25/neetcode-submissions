class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        int[][] A = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }

        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
        int l = 0, r = nums.length -1;
        while (l < r) {
            int sum = A[l][0] + A[r][0];
            if (sum == target) {
                return new int[]{Math.min(A[l][1], A[r][1]),
                                 Math.max(A[l][1], A[r][1])};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
