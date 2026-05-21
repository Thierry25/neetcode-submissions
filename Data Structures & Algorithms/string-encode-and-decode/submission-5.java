class Solution {

    public String encode(List<String> strs) {
        var newString = new StringBuilder();
        for (var s : strs) {
            newString.append("%d#%s".formatted(s.length(), s));
        }
        return newString.toString();
    }

    public List<String> decode(String str) {
        // 2#we3#say1#:3#yes10#!@#$%^&*()
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int hashIndex = str.indexOf("#", i);
            int len = Integer.parseInt(str.substring(i, hashIndex));

            var strStart = hashIndex + 1;
            result.add(str.substring(strStart, strStart + len));

            i = strStart + len;
        }

        return result;
    }
}
