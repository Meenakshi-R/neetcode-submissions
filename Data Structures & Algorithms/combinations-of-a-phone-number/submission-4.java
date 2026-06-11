class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");

        String[] digitsMapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (char ch : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String word : result) {
                for (char digit : digitsMapping[ch-'0'].toCharArray()) {
                    temp.add(word+digit);
                }
            }
            result = temp;
        }
        return result;
    }
}