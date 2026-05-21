class Solution {

    public String encode(List<String> strs) {
        var newString = new StringBuilder();
        for (var str : strs) {
            newString.append("%d#%s".formatted(str.length(), str));
        }
        return newString.toString();
    }

    public List<String> decode(String str) {
        // 2#we3#say1#:3#yes10#!@#$%^&*()
        List<String> strs = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int hashIndex = str.indexOf("#", i);
            String strLen = str.substring(i, hashIndex);
            int len = Integer.parseInt(strLen);

            int strStart = hashIndex + 1;
            strs.add(str.substring(strStart, strStart + len));

            i = strStart + len;
        }
        return strs;
    }
}
