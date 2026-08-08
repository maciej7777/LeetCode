package solutions.p3302;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("validSequenceCases")
    void validSequence(String word1, String word2, int[] expected) {
        assertArrayEquals(expected, solution.validSequence(word1, word2));

    }

    private static Stream<Arguments> validSequenceCases() {
        return Stream.of(
                arguments("vbcca", "abc", new int[]{0, 1, 2}),
                arguments("bacdc", "abc", new int[]{1, 2, 4}),
                arguments("aaaaaa", "aaabc", new int[]{}),
                arguments("abc", "ab", new int[]{0, 1}),
                arguments("abc", "abc", new int[]{0, 1, 2}),
                arguments("cbfabdemeffdbab", "deeef", new int[]{5, 6, 7, 8, 9})
        );
    }
}