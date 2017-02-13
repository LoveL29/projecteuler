package answers;

/**
 * Created by seok on 2017. 2. 13..
 *
 * Problem 9
 *
 * A Pythagorean triplet is
 * a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
    public static void main(String[] args) {
        for (int n = 0; n < 500 ; n++) {
            for (int m = (n+1); m < 500; m++) {
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;
                if (a + b + c == 1000){
                    System.out.println(a * b * c);
                }
            }
        }
    }
}
