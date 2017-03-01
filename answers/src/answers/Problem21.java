package answers;

/**
 * Created by seok on 2017. 2. 26..
 *
 * Problem 21
 *
 * https://projecteuler.net/problem=21
 */
public class Problem21 {
    public static void main(String[] args) {
        int answer = 0;
        for (double i = 1; i <= 10000; i++) {
            int sumA = 0;
            int sumB = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sumA += j;
                }
            }
            for (int z = 1; z < sumA; z++) {
                if (sumA % z == 0) {
                    sumB += z;
                }
            }
            if (i == sumB && sumA != sumB) {
                answer += i;
            }
        }
        System.out.println(answer);
    }
}
