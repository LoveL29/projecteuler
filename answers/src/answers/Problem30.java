package answers;

/**
 * Created by seok on 2017. 3. 9..
 *
 * Problem 30
 *
 * Surprisingly there are only three numbers
 * that can be written as the sum of fourth powers of their digits:
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers
 * that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {
    public static void main(String[] args) {
        int max = powInt(9, 5) * 6;
        int answer = 0;
        for (int i = 2; i < max; i++) {
            if (check5Powers(i)) {
                answer += i;
            }
        }
        System.out.println(answer);
    }

    private static boolean check5Powers(int num) {
        int powSum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            powSum += powInt(tmpNum % 10, 5);
            tmpNum /= 10;
        }
        return num == powSum;
    }

    private static int powInt(int a, int b) {
        int result = a;
        for (int i = 1; i < b; i++) {
           result *= a;
        }
        return result;
    }
}
