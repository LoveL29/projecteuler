package answers;

/**
 * Created by seok on 2017. 4. 10..
 *
 * Problem 36
 *
 * The decimal number, 585 = 1001001001 (binary),
 * is palindromic in both bases.
 * Find the sum of all numbers, less than one million,
 * which are palindromic in base 10 and base 2.
 * (Please note that the palindromic number,
 * in either base, may not include leading zeros.)
 */
public class Problem36 {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 1; i <= 1000000; i += 2) {
            if (isPalindromic(i, 10) && isPalindromic(i, 2)) {
                result += i;
            }
        }
        System.out.println(result);
    }

    private static boolean isPalindromic(int num, int digit) {
        int reversed = 0;
        int original = num;
        while (original > 0) {
            reversed = reversed * digit + original % digit;
            original /= digit;
        }
        return num == reversed;
    }
}
