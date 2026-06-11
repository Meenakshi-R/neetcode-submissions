class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m+n != s3.length()) {
            return false;
        }
         if (n < m) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            int tempLength = m;
            m = n;
            n = tempLength;
        }
        
        boolean[] prev = new boolean[n+1];
        prev[n] = true;

        for (int i=m; i>=0; i--) {
            boolean[] cur = new boolean[n+1];
            cur[n] = true;

            for (int j=n; j>=0; j--) {
                if(i<m && s1.charAt(i) == s3.charAt(i+j) && prev[j]) {
                    cur[j] = true;
                }
                if (j<n && s2.charAt(j) == s3.charAt(i+j) && cur[j+1]) {
                    cur[j] = true;
                }
            }
            prev = cur;
        }
        return prev[0];
    }
}
