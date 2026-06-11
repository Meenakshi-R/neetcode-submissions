class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int leftMin = 0, leftMax = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftMin++;
                leftMax++;
            }
            else if (ch == ')') {
                leftMin--;
                leftMax--;
            }
            else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                 return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
