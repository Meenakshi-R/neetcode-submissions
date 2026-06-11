class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digitsMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");

        for (char ch : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String currStr : result) {
                for (char c : digitsMap[ch-'0'].toCharArray()) {
                    temp.add(currStr+c);
                }
            }
            result = temp;
        }
        return result;
    }
}
