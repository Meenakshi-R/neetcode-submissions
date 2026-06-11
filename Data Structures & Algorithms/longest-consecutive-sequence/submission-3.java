class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            if (!set.contains(n-1)) {
                int length = 0;
                while (set.contains(n+length)) {
                   length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
