package answers;

import java.util.HashSet;

/**
 * Created by seok on 2017. 3. 11..
 *
 * Problem 32
 *
 * We shall say that an n-digit number is pandigital
 * if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254,
 * containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so
 * be sure to only include it once in your sum.
 */
public class Problem32 {
    public static void main(String[] args) {
        HashSet<Integer> products = new HashSet<>();
        int answer = 0;
        for (int multiplicand = 2; multiplicand < 100; multiplicand++) {
            int startMultiplier = (multiplicand > 9) ? 123 : 1234;
            int endMultiplier = 10000 / multiplicand + 1;
            for (int multiplier = startMultiplier; multiplier <= endMultiplier; multiplier++) {
                int product = multiplicand * multiplier;
                if (checkPandigital(multiplicand, multiplier, product)) {
                    products.add(product);
                }
            }
        }
        for (int product : products){
            answer += product;
        }
        System.out.println(answer);
    }

    private static boolean checkPandigital (int a, int b, int c) {
        HashSet<Integer> digitSet = new HashSet<>();
        int count = 0;
        while (a > 0) {
            digitSet.add(a % 10);
            a /= 10;
            count++;
        }
        while (b > 0) {
            digitSet.add(b % 10);
            b /= 10;
            count++;
        }
        while (c > 0) {
            digitSet.add(c % 10);
            c /= 10;
            count++;
        }
        return !digitSet.contains(0) && count == 9 && digitSet.size() == 9;
    }
}
