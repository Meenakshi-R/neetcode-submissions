class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int first = 1, second = 0, current = 0;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                current = 0;
            }
            else {
                current = first;
                if (i+1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
                    current += second;
                }
            }
            second = first;
            first = current;
            current = 0;
        }
        return first;
    }
}
