package solutions.p2996;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("scenarios")
    void shouldPassLeetCodeExamples(int[] nums, int expectedMissingInteger) {
        Assertions.assertEquals(expectedMissingInteger, solution.missingInteger(nums));
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(new int[]{1,2,3,2,5}, 6),
                arguments(new int[]{3,4,5,1,12,14,13}, 15)
        );
    }
}