package solutions.p1510;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionRecurrenceOptimizedTest {

    private final SolutionRecurrenceOptimized solutionRecurrence = new SolutionRecurrenceOptimized();

    @ParameterizedTest
    @MethodSource("scenarios")
    void shouldPassLeetCodeExample(int n, boolean expectedWin) {
        Assertions.assertEquals(expectedWin, solutionRecurrence.winnerSquareGame(n));
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(1, true),
                arguments(2, false),
                arguments(4, true)
        );
    }
}