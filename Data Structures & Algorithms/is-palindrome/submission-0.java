class Solution {
    public boolean isPalindrome(String s) {
         var newS = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
    int l = 0;
    int r = newS.length() - 1;

    while (l <= r) {
        if (newS.charAt(l) != newS.charAt(r)) {
            return false;
        }
        l++;
        r--;
    }
    return true;
    }
}
