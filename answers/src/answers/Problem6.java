package answers;

/**
 * Created by seok on 2017. 2. 10..
 *
 * Problem 6
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of
 * the first ten natural numbers and the square of the sum is 3025 − 385 = 2640
 * Find the difference between the sum of the squares of
 * the first one hundred natural numbers and the square of the sum.
 */
public class Problem6 {
    public static void main(String[] args) {
        System.out.println(squareOfSum(100) - sumOfSquare(100));
    }

    public static int squareOfSum(int lastNum) {
        int sum = 0;
        for (int i = 1; i <= lastNum; i++) {
            sum += i;
        }
        int result = sum * sum;
        return result;
    }

    public static int sumOfSquare(int lastNum) {
        int result = 0;
        for (int i = 1; i <= lastNum; i++) {
            result += i * i;
        }
        return result;
    }
}
