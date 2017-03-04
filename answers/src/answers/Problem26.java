package answers;

import java.util.HashMap;

/**
 * Created by seok on 2017. 3. 4..
 *
 * Problem 26
 *
 * A unit fraction contains 1 in the numerator.
 * The decimal representation of the unit fractions
 * with denominators 2 to 10 are given:
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
 * It can be seen that 1/7 has a 6-digit recurring cycle.
 * Find the value of d < 1000 for which 1/d
 * contains the longest recurring cycle in its decimal fraction part.
 */
public class Problem26 {
    public static void main(String[] args) {
        int longestNum = 0;
        int longestLen = 0;
        for (int i = 1; i <= 1000; i++) {
            int remaining = 1;
            int position = 0;
            HashMap<Integer, Integer> remainingMap = new HashMap<>();
            while (remaining != 0 && remainingMap.get(remaining) == 0) {
                remainingMap.put(remaining, position);
                remaining *= 10;
                remaining %= i;
                position++;
            }
            if (position - remainingMap.get(remaining) > longestLen) {
                longestLen = position;
                longestNum = i;
            }
        }
        System.out.println(longestNum);
    }
}
