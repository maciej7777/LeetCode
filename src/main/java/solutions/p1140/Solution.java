package solutions.p1140;

public class Solution {
    public int stoneGameII(int[] piles) {
        int[] suffixStones = new int[piles.length];

        int suffixSum = 0;
        for (int i = piles.length - 1; i >= 0; i--) {
            suffixSum += piles[i];
            suffixStones[i] = suffixSum;
        }

        Integer[][] memo = new Integer[piles.length][piles.length + 1];
        return calculateMaxStones(0, 1, suffixStones, memo);
    }

    private int calculateMaxStones(int i, int m, int[] suffixStones, Integer[][] memo) {
        if (i + 2 * m >= suffixStones.length) {
            return suffixStones[i];
        }
        if (memo[i][m] != null) {
            return memo[i][m];
        }

        int maxStones = 0;
        for (int x = 1; x <= 2 * m && x + i <= suffixStones.length; x++) {
            int myStones = suffixStones[i] - calculateMaxStones(i + x, Math.max(m, x), suffixStones, memo);

            if (myStones > maxStones) {
                maxStones = myStones;
            }
        }

        memo[i][m] = maxStones;
        return maxStones;
    }
}
