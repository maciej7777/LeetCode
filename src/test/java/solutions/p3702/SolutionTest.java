package solutions.p3702;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    Solution scenario = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void shouldPassLeetCodeExamples(final int[] nums, final int expectedLength) {
        assertEquals(expectedLength, scenario.longestSubsequence(nums));
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(new int[] {1,2,3}, 2),
                arguments(new int[] {2,3,4}, 3)
        );
    }
}