package answers;

/**
 * Created by seok on 2017. 3. 14..
 *
 * Problem 34
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers
 * which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {
    public static void main(String[] args) {
        // 9! * 7 = 2540160 (length 7) upper limit
        // 9! * 8 = 2903040 (length 7)
        int answer = 0;
        for (int i = 3; i <= 2540160; i++) {
            int sumFactorial = 0;
            int num = i;
            while (num > 0) {
                sumFactorial += factorial(num % 10);
                num /= 10;
            }
            if (sumFactorial == i) {
                answer += i;
            }
        }
        System.out.println(answer);
    }

    private static int factorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
