import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 7, 5, 3, 4, 6, 7, 8, 9};
        returnArrAfterNumberFour(array);

        System.out.println(returnArrContainsOneAndFour(array));
    }

    public static int[] returnArrAfterNumberFour(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException("Входной массив должен содержать хотя бы одну четверку");
    }

    public static boolean returnArrContainsOneAndFour(int[] arr) {
        for (int j : arr) {
            if (!(j == 1 | j == 4)) {
                return false;
            }
        }
        return Arrays.stream(arr).anyMatch(x -> x == 1) && Arrays.stream(arr).anyMatch(x -> x == 4);
    }

}
