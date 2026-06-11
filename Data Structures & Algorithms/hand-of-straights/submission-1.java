class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand == null || hand.length == 0 || groupSize == 0) {
            return true;
        }
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        int start = 0;
        for (int num : hand) {
            start = num;
            while (count.getOrDefault(start-1, 0) > 0) {
                start--;
            }
            while (start <= num) {
                while (count.getOrDefault(start, 0) > 0) {
                    for (int i=start; i<start+groupSize; i++) {
                        if (count.getOrDefault(i, 0) <= 0) {
                            return false;
                        }
                        count.put(i, count.get(i)-1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
