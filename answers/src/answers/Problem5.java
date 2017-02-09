package answers;

/**
 * Created by seok on 2017. 2. 9..
 *
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 * What is the smallest positive number
 * that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {
    public static void main(String[] args) {
        int result = 20;
        boolean isAnswer = false;
        while (!isAnswer) {
            result++;
            isAnswer = true;
            for (int i = 2; i <= 20; i++) {
                if (result % i != 0) {
                    isAnswer = false;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
