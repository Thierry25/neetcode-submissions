class Solution {
    public boolean isAnagram(String s, String t) {
        var mapFromS = generateMapFromString(s);
        var mapFromT = generateMapFromString(t);

        if (mapFromS.size() != mapFromT.size()) return false;
        // same size
        for (var entry : mapFromS.entrySet()) {
            var key = entry.getKey();
            if (!mapFromT.containsKey(key)) return false;

            var val = entry.getValue();
            var mapFromTValue = mapFromT.get(key);
            if (!Objects.equals(val, mapFromTValue)) return false;
        }

        return true;
    }

    public Map<Character, Integer> generateMapFromString(String value) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : value.toCharArray()) {
            result.merge(c, 1, Integer::sum);
        }

        return result;
    }
}
