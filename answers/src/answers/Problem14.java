package answers;

/**
 * Created by seok on 2017. 2. 18..
 *
 * Problem 14
 *
 * The following iterative sequence is
 * defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * Using the rule above and starting with 13,
 * we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem14 {
    public static void main(String[] args) {
        long largest = 0;
        int longest = 0;
        for (int i = 2; i <= 1000000; i++) {
            long starting = i;
            int counter = 1;
            while (starting > 1) {
                if (starting % 2 == 0) {
                    starting /= 2;
                } else {
                    starting = starting * 3 + 1;
                }
                counter += 1;
            }
            if (counter > longest) {
                longest = counter;
                largest = i;
            }
        }
        System.out.println(largest);
    }
}
