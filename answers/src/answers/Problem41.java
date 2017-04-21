package answers;

/**
 * Created by seok on 2017. 4. 15..
 *
 * We shall say that an n-digit number is pandigital
 * if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * What is the largest n-digit pandigital prime that exists?
 *
 */
public class Problem41 {
    public static void main(String args[]) {
        int result = 0;
        for (int i = 987654321; i > 1; i -= 2) {
            if (isPandigital(i) && isPrime(i)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean isPandigital(int num) {
        int digits = 0;
        int count = 0;
        int tmp;
        while (num > 0) {
            tmp = digits;
            digits = digits | 1 << ((num % 10) - 1);
            if (tmp == digits) {
                return false;
            }
            count++;
            num /= 10;
        }
        return digits == (1 << count) - 1;
    }

    private static boolean isPrime(int num) {
        for (int i = 3; i <= (int)Math.sqrt(num) + 1; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
