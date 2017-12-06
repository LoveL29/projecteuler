package answers;

import java.math.BigInteger;

/**
 * Created by seok on 2017. 12. 6..
 *
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem48 {
    public static void main(String args[]) {
        BigInteger result = BigInteger.ZERO;

        for (int i = 1; i <= 1000; i++) {
            result = result.add(BigInteger.valueOf(i).pow(i));
            result = result.mod(BigInteger.valueOf(100000).multiply(BigInteger.valueOf(100000)));
        }
        System.out.println(result);
    }
}
