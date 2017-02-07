package answers;

/**
 * Created by seok on 2017. 2. 5..
 *
 *  Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    public static void main(String[] args) {
        int result = sumMultiples(3, 1000) + sumMultiples(5, 1000)
                - sumMultiples(15, 1000);
        System.out.println(result);
    }

    public static int sumMultiples(int multiple, int max) {
        int sum = 0;
        int current = multiple;
        while (current < max) {
            sum = sum + current;
            current = current + multiple;
        }
        return sum;
    }
}
