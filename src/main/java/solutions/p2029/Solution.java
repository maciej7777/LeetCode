package solutions.p2029;

public class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] counters = new int[3];
        for (int stone : stones) {
            counters[stone % 3]++;
        }

        if (counters[0] % 2 == 0) {
            return counters[1] > 0 && counters[2] > 0;
        }

        return Math.abs(counters[1] - counters[2]) > 2;
    }
}
