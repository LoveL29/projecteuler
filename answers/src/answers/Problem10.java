package answers;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * Created by seok on 2017. 2. 14..
 *
 * Problem 10
 *
 * he sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Problem10 {
    public static void main(String[] args) {
        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        int i = 3;
        long sum = 2;
        while (i <= 2000000) {
            boolean isPrime = true;
            for (Integer prime : primeList) {
                if (i % prime == 0) {
                    isPrime = false;
                }
                if (prime > Math.sqrt(i)) {
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
                sum += i;
            }
            i = i + 2;
        }
        System.out.println(sum);
    }
}
