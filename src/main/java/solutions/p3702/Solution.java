package solutions.p3702;

public class Solution {
    public int longestSubsequence(int[] nums) {

        boolean hasNonZeroElements = false;
        int xor = 0;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZeroElements = true;
            }
        }

        if (!hasNonZeroElements) {
            return 0;
        }

        if (xor != 0) {
            return nums.length;
        }

        return nums.length - 1;
    }
}
