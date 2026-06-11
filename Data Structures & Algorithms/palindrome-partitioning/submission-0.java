class Solution {
    private void findPartitions(String s, List<String> path, List<List<String>> result, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                findPartitions(s, path, result, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
         while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
         }
         return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> path = new ArrayList<>();
        findPartitions(s, path, result, 0);
        return result;
    }
}
