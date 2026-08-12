package solutions.p2958;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        Map<Integer, Integer> numbersSpotted = new HashMap<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int currentElement = nums[right];
            numbersSpotted.merge(currentElement, 1, Integer::sum);

            while (numbersSpotted.get(currentElement) > k) {
                int leftElement = nums[left];
                numbersSpotted.merge(leftElement, -1, Integer::sum);

                if (numbersSpotted.get(leftElement) == 0) {
                    numbersSpotted.remove(leftElement);
                }

                left++;
            }

            if (right - left + 1 > max) {
                max = right - left + 1;
            }
        }

        return max;
    }
}
