import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestArrContainsOneAndFour {

    static Stream<Arguments> dataForReturnArrContainsOneAndFour() {
        return Stream.of(
                Arguments.arguments(true, new int[]{ 1, 1, 1, 4, 4, 1, 4, 4}),
                Arguments.arguments(false, new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.arguments(false, new int[]{4, 4, 4, 4}),
                Arguments.arguments(false, new int[]{1, 4, 4, 1, 1, 4, 3}),
                Arguments.arguments(true, new int[]{4, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForReturnArrContainsOneAndFour")
    void returnArrContainsOneAndFour(boolean exp, int[] arr) {
        Assertions.assertEquals(exp, MainClass.returnArrContainsOneAndFour(arr));
    }

    @Test
    void return1ArrContainsOneAndFour() {
        Assertions.assertFalse(MainClass.returnArrContainsOneAndFour(new int[]{2,3,5,1,9,0,7}));
    }

    @Test
    void return2ArrContainsOneAndFour() {
        Assertions.assertThrows(NumberFormatException.class, () ->
                MainClass.returnArrContainsOneAndFour(new int[]{Integer.parseInt("Hello")}));
    }
}

