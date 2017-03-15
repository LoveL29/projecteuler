package answers;

/**
 * Created by seok on 2017. 3. 13..
 *
 * Problem 33
 *
 * The fraction 49/98 is a curious fraction,
 * as an inexperienced mathematician in attempting to simplify
 * it may incorrectly believe that 49/98 = 4/8, which is correct,
 * is obtained by cancelling the 9s.
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * There are exactly four non-trivial examples of this type of fraction,
 * less than one in value, and containing two digits
 * in the numerator and denominator.
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 *
 */
public class Problem33 {
    public static void main(String[] args) {
        // 0 < x < y < 10
        // 10n + x / 10n + y = x / y -> x = y (false)
        // 10x + n / 10n + y = x / y -> 9x(y - n) = n(x - y) -> x < y < n (true)
        // 10n + x / 10y + n = x / y -> x - n = n / 9 - nx / 9y -> x - n > 0 && n / 9 < 0 (false)
        // 10x + n / 10y + n = x / y -> x = y (false)
        // 0 < x < y < n < 10
        int moleculeMul = 1;
        int denominatorMul =1;
        for (int n = 1; n < 10; n++) {
            for (int y = 1; y < n; y++) {
                for (int x = 1; x < y; x++) {
                    if ((10 * x + n) * y == (10 * n + y) * x) {
                        moleculeMul *= x;
                        denominatorMul *= y;
                    }
                }
            }
        }
        System.out.println(denominatorMul / gcd(moleculeMul, denominatorMul));
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return gcd(b,a%b);
    }
}
