package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2017. 3. 17..
 *
 * Problem 35
 *
 * The number, 197, is called a circular prime
 * because all rotations of the digits: 197, 971, and 719, are themselves prime
 * There are thirteen such primes below 100:
 * 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * How many circular primes are there below one million?
 */
public class Problem35 {
    public static void main(String[] args) {
        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        int circularPrimeCount = 1;
        int i = 3;
        while (i <= 1000000) {
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
            }
            i = i + 2;
        }
        for (Integer prime : primeList) {
            boolean isCircularPrime = true;
            String str = Integer.toString(prime);
            for (int j = 0; j < str.length(); j++) {
                int checkNum = Integer.parseInt(str.substring(j) + str.substring(0, j));
                for (Integer prime1 : primeList) {
                    if (checkNum % prime1 == 0) {
                        isCircularPrime = false;
                    }
                    if (prime1 > Math.sqrt(checkNum)) {
                        break;
                    }
                }
            }
            if (isCircularPrime) {
                circularPrimeCount++;
            }
        }
        System.out.println(circularPrimeCount);
    }
}
