package answers;

/**
 * Created by seok on 2017. 2. 7..
 *
 * Problem 3
 * Largest prime factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {
    public static void main(String[] args) {
        long factor = 2;
        long c = 600851475143L;
        while (factor < c) {
            while (c % factor == 0) {
                c /= factor;
            }
            factor++;
        }
        System.out.println(factor);
    }
}
