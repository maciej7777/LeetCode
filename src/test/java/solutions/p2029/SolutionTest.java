package solutions.p2029;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {
    Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void shouldPassLeetCodeExampleScenarios(final int[] stones, final boolean expectedWinner) {
        assertEquals(expectedWinner, solution.stoneGameIX(stones));
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(new int[] {2,1}, true),
                arguments(new int[] {2}, false),
                arguments(new int[] {5,1,2,4,3}, false)
        );
    }
}