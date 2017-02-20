package answers;

import java.math.BigInteger;

/**
 * Created by seok on 2017. 2. 20..
 *
 * Problem 16
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */
public class Problem16 {
    public static void main(String[] args) {
        BigInteger result = BigInteger.valueOf(2);
        result = result.pow(1000);
        String resultStr = result.toString();
        int answer = 0;
        for (int i = 0; i < resultStr.length(); i++) {
            answer += Character.getNumericValue(resultStr.charAt(i));
        }
        System.out.println(answer);
    }
}
