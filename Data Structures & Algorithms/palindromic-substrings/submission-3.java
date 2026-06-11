class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i=0; i<n; i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i+1);
        }
        return count;
    }

    private int countPalindromes(String s, int l, int r) {
        int n = s.length();
        int count = 0;

        while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
