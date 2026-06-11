class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = 0, longest = Integer.MIN_VALUE;
        for (int element : set) {
            length = 0;
            if (!set.contains(element-1)) {
                length = 1;
                while(set.contains(element+length)) {
                   length++;
                }
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
