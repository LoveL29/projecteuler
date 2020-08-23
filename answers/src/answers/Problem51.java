package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2018. 2. 13..
 *
 * Problem 51
 * By replacing the 1st digit of the 2-digit number *3,
 * it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes
 * among the ten generated numbers, yielding the family:
 * 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family,
 * is the smallest prime with this property.
 * Find the smallest prime which, by replacing part of the number
 * (not necessarily adjacent digits) with the same digit,
 * is part of an eight prime value family.
 *
 */
public class Problem51 {
    static private List<Long> primeList = new ArrayList<>();

    public static void main(String args[]) {
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


        int[][] patterns = get6digitPatterns();
        long result = 1000000;

        for (int c = 11; c < 1000; c += 2) {

            if (c % 5 == 0) {
                continue;
            }

            for (int[] pattern1 : patterns) {
                for (int k = 0; k <= 2; k++) {

                    if (pattern1[0] == 0 && k == 0) {
                        continue;
                    }

                    int[] pattern = fillPattern(pattern1, c);
                    long candidate = generateNumber(k, pattern);

                    if (candidate < result && (primeList.indexOf(candidate) > 0)) {
                        if (familySize(k, pattern) == 8) {
                            result = candidate;
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int[][] get6digitPatterns() {
        int[][] retVal = new int[10][];

        retVal[0] = new int[] { 1, 1, 0, 0, 0, 1 };
        retVal[1] = new int[] { 1, 0, 1, 0, 0, 1 };
        retVal[2] = new int[] { 1, 0, 0, 1, 0, 1 };
        retVal[3] = new int[] { 1, 0, 0, 0, 1, 1 };
        retVal[4] = new int[] { 0, 1, 1, 0, 0, 1 };
        retVal[5] = new int[] { 0, 1, 0, 1, 0, 1 };
        retVal[6] = new int[] { 0, 1, 0, 0, 1, 1 };
        retVal[7] = new int[] { 0, 0, 1, 1, 0, 1 };
        retVal[8] = new int[] { 0, 0, 1, 0, 1, 1 };
        retVal[9] = new int[] { 0, 0, 0, 1, 1, 1 };

        return retVal;
    }

    private static int[] fillPattern(int[] pattern, int number) {
        int[] filledPattern = new int[pattern.length];
        int temp = number;

        for (int i = filledPattern.length - 1; 0 <= i; i--) {
            if (pattern[i] == 1) {
                filledPattern[i] = temp % 10;
                temp /= 10;
            } else {
                filledPattern[i] = -1;
            }
        }
        return filledPattern;
    }

    private static long generateNumber(int repNumber, int[] filledPattern) {
        long temp = 0;
        for (int aFilledPattern : filledPattern) {
            temp = temp * 10;
            temp += (aFilledPattern == -1) ?
                    repNumber : aFilledPattern;
        }
        return temp;
    }

    private static int familySize(int repeatingNumber, int[] pattern) {
        int familySize = 1;

        for (int i = repeatingNumber + 1; i < 10; i++) {
            if (primeList.indexOf(generateNumber(i, pattern)) > 0) {
                familySize++;
            }
        }

        return familySize;
    }
}
