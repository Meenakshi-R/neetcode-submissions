class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        int count = 0;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
               if (!(isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1))) {
                   return false;
               }
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}