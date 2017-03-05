package answers;

/**
 * Created by seok on 2017. 3. 5..
 *
 * Problem 27
 *
 * Euler discovered the remarkable quadratic formula:
 * n^2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive
 * integer values 0≤n≤39.
 * However, when n=40,40^2+40+41=40(40+1)+41 is divisible by 41,
 * and certainly when n=41,412+41+41 is clearly divisible by 41.
 * The incredible formula n^2−79n+1601 was discovered,
 * which produces 80 primes for the consecutive values 0≤n≤79.
 * The product of the coefficients, −79 and 1601, is −126479.
 * Considering quadratics of the form:
 * n^2+an+b, where |a|<1000 and |b|≤1000
 * where |n||n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b,
 * for the quadratic expression that produces the maximum number of primes
 * for consecutive values of n, starting with n=0.
 */
public class Problem27 {
    public static void main(String[] args) {
        int maximumPrimeCount = 0;
        int answerA = 0;
        int answerB = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int primeCount = getPrimeCount(a, b);
                if (primeCount > maximumPrimeCount) {
                    maximumPrimeCount = primeCount;
                    answerA = a;
                    answerB = b;
                }
            }
        }
        System.out.println(answerA * answerB);
    }

    private static int getPrimeCount (int x, int y) {
        for (int i = 0; ; i++) {
            int z = i * i + i * x + y;
            if (z <= 0 || !isPrime(z)) {
                return i;
            }
        }
    }

    private static boolean isPrime (int num) {
        for (int i = 2; i <= (int)Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
