package main.java.solutions.p3302;

public class Solution {
    public int[] validSequence(String word1, String word2) {

        int[] suffix = createSuffixTable(word1, word2);

        int [] solution = new int[word2.length()];
        boolean changed = false;
        int j = 0;
        for (int position = 0; position < word1.length() && j < word2.length(); position++) {
            if (word1.charAt(position) == word2.charAt(j)) {
                solution[j] = position;
                j++;
            } else if (!changed && (j + 1 == word2.length() || suffix[j+1] > position)) {
                solution[j] = position;
                changed = true;
                j++;
            }
        }

        if (j < word2.length()) {
            return new int[0];
        }

        return solution;
    }

    private static int[] createSuffixTable(String word1, String word2) {
        int[] suffix = new int[word2.length()];
        int position = word1.length();
        for (int i = word2.length() - 1; i >= 0; i--) {
            if (position != -1) {
                position--;
                while (position >= 0 && word1.charAt(position) != word2.charAt(i)) {
                    position--;
                }

            }
            suffix[i] = position;

        }
        return suffix;
    }
}
