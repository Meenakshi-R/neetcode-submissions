class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i=0; i<n; i++) {
            count += countUtil(s, i, i);
            count += countUtil(s, i, i+1);
        }
        return count;
    }

    private int countUtil(String s, int left, int right) {
        int len = 0;
        
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            len++;
        }
        return len;
    }
}
