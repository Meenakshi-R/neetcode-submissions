class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int maxFrequency = 0, maxCount = 0;

        for (char ch : tasks) {
            count[ch-'A']++;
            maxFrequency = Math.max(maxFrequency, count[ch-'A']);
        }
        for (int i : count) {
            if (i == maxFrequency) {
                maxCount++;
            }
        }
        int time = (maxFrequency-1)*(n+1) + maxCount;
        return Math.max(tasks.length, time);
    }
}

