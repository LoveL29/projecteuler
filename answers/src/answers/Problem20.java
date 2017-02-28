package answers;

import java.math.BigInteger;

/**
 * Created by seok on 2017. 2. 25..
 *
 * Problem 20
 *
 * https://projecteuler.net/problem=20
 */
public class Problem20 {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("100");
        BigInteger result = factorials(num);
        String resultStr = result.toString();
        int answer = 0;
        for (int i = 0; i < resultStr.length(); i++) {
            int j = Integer.parseInt(resultStr.substring(i,i+1));
            answer += j;
        }
        System.out.println(answer);
    }
    private static BigInteger factorials(BigInteger num) {
        if (num.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return num.multiply(factorials(num.subtract(BigInteger.ONE)));
        }
    }
}
