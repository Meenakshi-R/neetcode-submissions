class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return -1;
        }
        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        int max = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;
        for (int i : count) {
            if (i == max) {
                maxCount++;
            }
        }
        int time = (max-1)*(n+1)+maxCount;
        return Math.max(tasks.length, time);
    }
}
