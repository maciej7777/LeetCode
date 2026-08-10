package solutions.p1510;

import java.util.HashMap;
import java.util.Map;

public class SolutionRecurrence {
    public boolean winnerSquareGame(int n) {
        Map<Integer, Boolean> memo = new HashMap<>();

        return calculateWinner(n, memo);
    }

    private boolean calculateWinner(int n, Map<Integer, Boolean> memo) {
        if (n == 0) {
            return false;
        }
        if (memo.get(n) != null) {
            return memo.get(n);
        }

        boolean winner = false;
        for (int i = 1; i*i <= n; i++) {
            boolean winnerRound = !calculateWinner(n - i*i, memo);

            if (winnerRound) {
                winner = true;
                break;
            }
        }

        memo.put(n, winner);
        return winner;
    }
}
