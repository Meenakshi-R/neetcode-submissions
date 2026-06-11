class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
         if(digits == null || digits.length() == 0) {
            return result;
        }
        String[] digitsMapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String word : result) {
                for (char ch : digitsMapping[digit-'0'].toCharArray()) {
                    temp.add(word+ch);
                }
            }
            result = temp;
        }
        return result;
    }
}
