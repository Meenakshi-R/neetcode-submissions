class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int opt1 = 1, opt2 = 0;

        for (int i=n-1; i>=0; i--) {
            int current = 0;
            char ch = s.charAt(i);
            if (ch == '0') {
                current = 0;
            }
            else {
                current = opt1;
                if (i+1<n && (ch == '1' || (ch =='2' && s.charAt(i+1) < '7'))) {
                    current += opt2;
                }
            }
            opt2 = opt1;
            opt1 = current;
        }
        return opt1;
    }
}
