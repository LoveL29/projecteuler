package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by seok on 2017. 3. 1..
 *
 * Problem 24
 *
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic
 * permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem24 {
    public static void main(String[] args) {
        String answer = "";
        int result = 1000000;
        int sum = 0;
        List<String> numStr = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        while (numStr.size() > 1) {
            int lexCount = factorials(numStr.size() - 1);
            for(int i = 0; i < numStr.size(); i++) {
                 if (sum + (lexCount * (i + 1)) >= result) {
                     sum += lexCount * i;
                     answer += numStr.get(i);
                     numStr.remove(i);
                     break;
                 }
            }
        }
        answer += numStr.get(0);
        System.out.println(answer);
    }

    private static int factorials(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorials(num - 1);
        }
    }
}
