package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2018. 1. 8..
 *
 * Problem 49
 * The arithmetic sequence, 1487, 4817, 8147,
 * in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * What 12-digit number
 * do you form by concatenating the three terms in this sequence?
 */
public class Problem49 {
    static private List<Integer> primeList = new ArrayList<>();

    public static void main(String args[]) {

        long result = 0;
        int limit = 10000;
        primeList.add(2);
        int i = 3;
        while (i < limit) {
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

        for (int n = 0; n < primeList.size(); n++) {
            for (int j = n + 1; j < primeList.size(); j++) {
                int k = primeList.get(j) + (primeList.get(j) - primeList.get(n));
                if (k < limit && primeList.indexOf(k) > 0) {
                    if (isPermutation(primeList.get(n), primeList.get(j)) &&
                            isPermutation(primeList.get(n), k) &&
                            primeList.get(n) != 1487) {
                        result = concat(concat(primeList.get(n), primeList.get(j)), k);
                        break;
                    }
                }
            }
            if (result > 0) {
                break;
            }
        }

        System.out.println(result);
    }

    static private long concat(long a, long b) {
        long c = b;
        while (c > 0) {
            a *= 10;
            c /= 10;
        }
        return a + b;
    }

    static private boolean isPermutation(int a, int b) {
        int[] arr = new int[10];

        int temp = a;
        while(temp > 0){
            arr[temp % 10]++;
            temp /= 10;
        }

        temp = b;
        while(temp > 0){
            arr[temp % 10]--;
            temp /= 10;
        }

        for(int i = 0; i< 10; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
