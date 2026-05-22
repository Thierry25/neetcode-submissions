class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak = 0;
        for (var n : set) {
            if (!set.contains(n -1)) {
                int currentNum = n;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                } 
                
                maxStreak = Math.max(currentStreak, maxStreak);
            }
        }

        return maxStreak;
    }
}
