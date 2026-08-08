package solutions.p3345;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void smallestNumber(int n, int t, int expected) {
        assertEquals(expected, solution.smallestNumber(n, t));
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(10, 2, 10),
                arguments(15, 3, 16),
                arguments(1, 5, 5)
        );
    }
}