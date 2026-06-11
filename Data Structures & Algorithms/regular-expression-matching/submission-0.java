class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] prev = new boolean[n+1];
        prev[n] = true;

        for (int i=m; i>=0; i--) {
            boolean[] cur = new boolean[n+1];
            cur[n] = (i==s.length());
            
            for (int j=n-1; j>=0; j--) {
                boolean match = (i<m) && (s.charAt(i) == p.charAt(j) || p.charAt(j)=='.');
                if(j+1 < n && p.charAt(j+1)=='*') {
                    cur[j] = cur[j+2] || (match && prev[j]);
                }
                else if (match) {
                    cur[j] = prev[j+1];
                }
            }
            prev = cur;
        }
        return prev[0];
    }
}