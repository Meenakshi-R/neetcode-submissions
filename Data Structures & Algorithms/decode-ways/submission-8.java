class Solution {
    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) {
            return 1;
        }
        if (i>s.length()) {
            return 0;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int result = dfs(s, i+1);
        if (i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
            result += dfs(s, i+2);
        }
        return result;
    }
}
