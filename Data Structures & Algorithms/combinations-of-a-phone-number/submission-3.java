class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        String[] digitsMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (char ch : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String res : result) {
                for (char c : digitsMap[ch-'0'].toCharArray()) {
                    temp.add(res+c);
                }
            }
            result = temp;
        }
        return result;
    }
}
