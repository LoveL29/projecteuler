package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2018. 1. 14..
 *
 * Problem 50
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes
 * that adds to a prime below one-hundred.
 * The longest sum of consecutive primes below one-thousand that adds to a prime,
 * contains 21 terms, and is equal to 953.
 * Which prime, below one-million,
 * can be written as the sum of the most consecutive primes?
 *
 */
public class Problem50 {
    static private List<Long> primeList = new ArrayList<>();

    public static void main(String args[]) {
        long result = 0;
        int limit = 1000000;
        primeList.add((long) 2);
        long i = 3;
        while (i < limit) {
            boolean isPrime = true;
            for (Long prime : primeList) {
                if (i % prime == 0) {
                    isPrime = false;
                }
                if (prime > Math.sqrt(i)) {
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
            i = i + 2;
        }

        long[] primeSum = new long[primeList.size() + 1];
        primeSum[0] = 0;
        int countPrimes = 0;
        for (int n = 0; n < primeList.size(); n++) {
            primeSum[n + 1] = primeSum[n] + primeList.get(n);
        }

        for (int n = countPrimes; n < primeList.size(); n++) {
            for (int j = n - (countPrimes + 1); j >= 0; j--) {
                if (primeSum[n] - primeSum[j] > limit) {
                    break;
                }
                if (primeList.indexOf(primeSum[n] - primeSum[j]) > 0) {
                    countPrimes = n - j;
                    result = primeSum[n] - primeSum[j];
                }
            }
        }

        System.out.println(result);
    }
}
