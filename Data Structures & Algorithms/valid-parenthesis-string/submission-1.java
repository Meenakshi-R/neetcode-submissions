class Solution {
    public boolean checkValidString(String s) {
        int leftMax = 0, leftMin = 0;

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if ('(' == currentChar) {
                leftMax++;
                leftMin++;
            }
            else if (')' == currentChar) {
                leftMax--;
                leftMin--;
            }
            else {
                leftMax++;
                leftMin--;
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
