class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> countMap = new HashMap<>();
        for (var n : nums) {
            countMap.merge(n, 1, Integer::sum);
        }

        return countMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
