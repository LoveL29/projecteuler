package answers;

/**
 * Created by seok on 2017. 2. 19..
 *
 * Problem 15
 *
 * Starting in the top left corner of a 2×2 grid,
 * and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 */
public class Problem15 {
    public static void main(String[] args) {
        // reference : Binomial coefficient
        long result = 1;
        for (int i = 0; i < 20; i++)
        {
            result = result * (40-i);
            result = result / (i+1);
        }
        System.out.println(result);
    }
}
