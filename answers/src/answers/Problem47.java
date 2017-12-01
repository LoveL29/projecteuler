package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2017. 12. 1..
 *
 * The first two consecutive numbers to have two distinct prime factors are:
 * 14 = 2 × 7
 * 15 = 3 × 5
 * The first three consecutive numbers to have three distinct prime factors are:
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * Find the first four consecutive integers
 * to have four distinct prime factors each. What is the first of these numbers?
 */
public class Problem47 {

    static private List<Integer> primeList = new ArrayList<>();

    public static void main(String args[]) {

        primeList.add(2);
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

        int result = 2 * 3 * 5 * 7;
        int count = 0;
        int endCount = 3;

        while (count <= endCount) {
            result++;

            if (countOfPrimeFactors(result) >= 4) {
                count++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }

    static private int countOfPrimeFactors(int number) {
        int nod = 0;
        boolean pf;
        int remain = number;

        for (Integer aPrimeList : primeList) {

            if (aPrimeList * aPrimeList > number) {
                return ++nod;
            }
            pf = false;
            while (remain % aPrimeList == 0) {
                pf = true;
                remain = remain / aPrimeList;
            }
            if (pf) {
                nod++;
            }
            if (remain == 1) {
                return nod;
            }
        }
        return nod;
    }
}
