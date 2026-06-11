class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int i, List<String> ds) {
        if (i>=s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int j=i; j<s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                ds.add(s.substring(i, j+1));
                dfs(s, j+1, ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
