package answers;

/**
 * Created by seok on 2017. 2. 8..
 *
 * Problem4
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is
 * 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
    public static void main(String[] args) {
        System.out.println(palindromic());
    }

    public static int reverseInt(int num) {
        int result = 0;
        while (num > 0) {
            result *= 10;
            int insertNum = num % 10;
            num /= 10;
            result += insertNum;
        }
        return result;
    }

    public static int palindromic() {
        int palindrome = 0;
        for (int i = 999 ; i >= 900 ; i--) {
            for (int j = 999 ; j >= 900 ; j--) {
                palindrome = i * j;
                if (palindrome == reverseInt(palindrome)) {
                    return palindrome;
                }
            }
        }
        return 0;
    }
}
