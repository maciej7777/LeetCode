package solutions.p1140;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
    void shouldPassLeetCodeExample(final int[] piles, int expectedStones) {
        Assertions.assertEquals(expectedStones, solution.stoneGameII(piles));
    }

    private static Stream<Arguments> scenarios(){
        return Stream.of(
               arguments(new int[]{2,7,9,4,4}, 10),
               arguments(new int[]{1,2,3,4,5,100}, 104)
        );
    }
}