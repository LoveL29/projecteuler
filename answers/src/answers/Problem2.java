package answers;

/**
 * Created by seok on 2017. 2. 6..
 *
 * Problem 2
 * Each new term in the Fibonacci sequence is generated
 * by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence
 * whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class Problem2 {
    public static void main(String[] args){
        long sum = 0;
        int i = 1;
        long fibResult = 1;
        while (fibResult < 4000000) {
            fibResult = fibonacci(i);
            if (fibResult % 2 == 0){
                sum += fibResult;
            }
            i++;
        }
        System.out.println(sum);
    }

    public static long fibonacci(int n){
        if (n < 2) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
