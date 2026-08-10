package solutions.p1510;

public class SolutionRecurrenceOptimized {
    private static final byte NOT_CALCULATED = 0;
    private static final byte LOSS = 1;
    private static final byte WIN = 2;

    public boolean winnerSquareGame(int n) {
        byte[] memo = new byte[n + 1];


        return calculateWinner(n, memo);
    }

    private boolean calculateWinner(int n, byte[] memo) {
        if (n == 0) {
            return false;
        }
        if (memo[n] != NOT_CALCULATED) {
            return memo[n] == WIN;
        }

        for (int i = 1; i*i <= n; i++) {
            if (!calculateWinner(n - i*i, memo)) {
                memo[n] = WIN;
                return true;
            }
        }

        memo[n] = LOSS;
        return false;
    }
}
