class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (char ch : digits.toCharArray()) {
            List<String> temp = new ArrayList();
            for (String currentStr : result) {
                for (char c : mapping[ch-'0'].toCharArray()) {
                    temp.add(currentStr+c);
                }
            }
            result = temp;
        }
        return result;
    }
}
