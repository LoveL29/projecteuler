package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by seok on 2017. 4. 11..
 *
 * The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits
 * from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 * Find the sum of the only eleven primes
 * that are both truncatable from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.


 */
public class Problem37 {
    private static List<Integer> primeList = new ArrayList<>();

    public static void main(String args[]) {
        primeList.addAll(Arrays.asList(2, 3, 5, 7));
        int result = 0;
        int count = 0;
        int i = 11;
        while (count < 11) {
            if (isPrime(i)) {
                primeList.add(i);
                int rightPart = i;
                int leftPart = 0;
                int multiplier = 1;
                boolean isTruncatable = true;
                while (rightPart > 0 && isTruncatable) {
                    leftPart += multiplier * (rightPart % 10);
                    isTruncatable = isPrime(leftPart) && isPrime(rightPart);
                    rightPart /= 10;
                    multiplier *= 10;
                }
                if (isTruncatable) {
                    count++;
                    result += i;
                }
            }
            i = i + 2;
        }
        System.out.println(result);
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (Integer prime : primeList) {
            if (num % prime == 0 && num / prime != 1) {
                return false;
            }
            if (prime > Math.sqrt(num)) {
                break;
            }
        }
        return true;
    }
}
