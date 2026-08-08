package solutions.p3345;

public class Solution {
    public int smallestNumber(int n, int t) {
        int product;
        int current = n-1;

        do {
            current++;
            product = 1;
            String nString = Integer.toString(current);
            for (int i = 0; i < nString.length(); i++) {
                product *= (nString.charAt(i) - '0');
            }
        } while (product % t != 0);

        return current;
    }
}
