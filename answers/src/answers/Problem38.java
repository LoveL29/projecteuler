package answers;

/**
 * Created by seok on 2017. 4. 12..
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576.
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * The same can be achieved by starting with 9 and
 * multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 * which is the concatenated product of 9 and (1,2,3,4,5).
 * What is the largest 1 to 9 pandigital 9-digit number
 * that can be formed as the concatenated product of
 * an integer with (1,2, ... , n) where n > 1?
 *
 */
public class Problem38 {
    public static void main(String args[]) {
        long result = 0;
        for (long i = 9876; i >= 9123; i--) {
            result = unionNum(i , i * 2);
            if (isPandigital(result)) {
                break;
            }
        }
        System.out.println(result);
    }

    private static long unionNum(long a, long b) {
        long temp = b;
        while (temp > 0) {
            temp /= 10;
            a *= 10;
        }
        return a + b;
    }

    private static boolean isPandigital(long num) {
        int digits = 0;
        int count = 0;
        int tmp;
        while (num > 0) {
            tmp = digits;
            digits = digits | 1 << (int)((num % 10) - 1);
            if (tmp == digits) {
                return false;
            }
            count++;
            num /= 10;
        }
        return digits == (1 << count) - 1;
    }
}
