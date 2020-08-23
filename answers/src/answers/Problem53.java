package answers;

import java.math.BigInteger;

/**
 * Created by seok on 2020. 8. 23..
 *
 * Problem 53
 * https://projecteuler.net/problem=53
 *
 */
public class Problem53 {
    public static void main(String args[]) {
        int result = 0;
		for (int n = 1; n <= 100; n ++) {
			for (int r = 1; r <= n; r++) {
				if (factorialBig(new BigInteger(String.valueOf(n)))
						.divide(factorialBig(new BigInteger(String.valueOf(r)))
						.multiply(factorialBig(new BigInteger(String.valueOf(n - r)))))
						.compareTo(new BigInteger("1000000"))
						>= 0) {
					result++;
				}
			}
		}

        System.out.println(result);
    }

	private static BigInteger factorialBig(BigInteger num) {
		if (num.compareTo(BigInteger.ONE) <= 0) {
			return BigInteger.ONE;
		} else {
			return num.multiply(factorialBig(new BigInteger(String.valueOf(num.intValue() - 1))));
		}
	}
}
