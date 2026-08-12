package solutions.p2958;

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
    void shouldPassLeetCodeExamples(int[] nums, int k, int expectedLength) {
        assertEquals(expectedLength, solution.maxSubarrayLength(nums, k));
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(new int[] {1,2,3,1,2,3,1,2}, 2, 6),
                arguments(new int[] {1,2,1,2,1,2,1,2}, 1, 2),
                arguments(new int[] {5,5,5,5,5,5,5}, 4, 4)
        );
    }
}