package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2017. 11. 30..
 *
 * It was proposed by Christian Goldbach that every odd composite number
 * can be written as the sum of a prime and twice a square.
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * It turns out that the conjecture was false.
 * What is the smallest odd composite
 * that cannot be written as the sum of a prime and twice a square?
 *
 */
public class Problem46 {
    public static void main(String args[]) {

        List<Integer> primeList = new ArrayList<>();
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

        int result = 1;
        boolean notEnd = true;

        while ( notEnd ) {
            result += 2;

            notEnd = false;
            int count = 0;
            while ( result >= primeList.get(count)) {
                if ( isTwiceSquare(result - primeList.get(count)) ) {
                    notEnd = true;
                    break;
                }
                count++;
            }
        }

        System.out.println(result);
    }

    private static boolean isTwiceSquare(int num) {
        double squareTest = Math.sqrt(num/2);
        return squareTest == ((int)squareTest);
    }
}
