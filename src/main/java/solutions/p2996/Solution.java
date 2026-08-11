package solutions.p2996;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                prefixSum += nums[i];
            } else {
                break;
            }
        }

        Set<Integer> numbers = new HashSet<>(nums.length);
        for (int num : nums) {
            numbers.add(num);
        }

        while (numbers.contains(prefixSum)) {
            prefixSum++;
        }

        return prefixSum;
    }
}
