class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
            String t = word1;
            word1 = word2;
            word2 = t;
        }

        int[] prev = new int[n+1];
        int[] cur = new int[n+1];

        for (int j = 0; j <=n; j++) {
            prev[j] = n-j;
        }
        for (int i=m-1; i>=0; i--) {
            cur[n] = m-i;

            for (int j=n-1; j>=0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                   cur[j] = prev[j+1];
                }
                else {
                  cur[j] = 1 + Math.min(prev[j], Math.min(cur[j+1], prev[j+1]));
                }
            }
            System.arraycopy(cur, 0, prev, 0, n + 1);
        }
        return prev[0];
    }
}
