class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
            Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                    s -> s.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum)),
                    Collectors.toList()
                ))
                .values()
        );
    }
}
