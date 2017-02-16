package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2017. 2. 11..
 *
 * Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 */
public class Problem7 {
    public static void main(String[] args) {
        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        int i = 3;
        while (primeList.size() <= 10000) {
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
        System.out.println(primeList.get(10000));
    }
}
