import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestArrAfterNumberFour {
    static Stream<Arguments> dataForTestReturnArrAfterNumberFour() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{}, new int[]{1, 2, 4, 4, 2, 4}),
                Arguments.arguments(new int[]{1, 7, 5, 6, 1}, new int[]{1, 2, 4, 4, 1, 7, 5, 6, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTestReturnArrAfterNumberFour")
    void testReturnArrAfterNumberFour(int[] exp, int[] arr) {
        Assertions.assertArrayEquals(exp, MainClass.returnArrAfterNumberFour(arr));
    }

    @Test
    void test1ReturnArrAfterNumberFour() {
        Assertions.assertArrayEquals(new int[]{2,1}, MainClass.returnArrAfterNumberFour(new int[]{1,2,4,5,6,4,2,1,}));
    }

    @Test
    void test2ReturnArrAfterNumberFour() {
        Assertions.assertThrows(RuntimeException.class, () -> MainClass.returnArrAfterNumberFour(new int[]{1, 2, 1, 7, 444, 44, 14}));
    }

}
