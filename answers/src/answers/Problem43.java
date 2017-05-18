package answers;

/**
 * Created by seok on 2017. 5. 18..
 *
 * The number, 1406357289, is a 0 to 9 pandigital number
 * because it is made up of each of the digits 0 to 9 in some order,
 * but it also has a rather interesting sub-string divisibility property.
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on.
 * In this way, we note the following:d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem43 {
    private static int[] pandigit = new int[] { 1, 0, 2, 3, 4, 5, 6, 7, 8, 9 };

    public static void main(String args[]) {
        //d6 == 0 or 5
        //d6d7d8 % 11 = 0 so if d6 == 0 then 011, 022. so d6 == 5
        long result = 0;
        int[] divisors = { 1, 2, 3, 5, 7, 11, 13, 17 };
        int count = 1;
        int numPandigit = 3265920; //9 * 9!
        while (count < numPandigit) {
            int N = pandigit.length;
            int i = N - 1;

            while (pandigit[i - 1] >= pandigit[i]) {
                i = i - 1;
            }

            int j = N;
            while (pandigit[j - 1] <= pandigit[i - 1]) {
                j = j - 1;
            }

            // swap values at position i-1 and j-1
            swap(i - 1, j - 1);

            i++;
            j = N;

            while (i < j) {
                swap(i - 1, j - 1);
                i++;
                j--;
            }
            boolean divisible = true;
            for (int k = 1; k < divisors.length; k++) {

                int num = 100 * pandigit[k] + 10 * pandigit[k + 1] + pandigit[k + 2];
                if (num % divisors[k] != 0 || pandigit[5] != 5) {
                    divisible = false;
                    break;
                }
            }
            if (divisible) {
                long num = 0;
                for (int aPandigit : pandigit) {
                    num = 10 * num + aPandigit;
                }
                result += num;
            }
            count++;
        }
        System.out.println(result);
    }

    private static void swap(int i, int j) {
        int k = pandigit[i];
        pandigit[i] = pandigit[j];
        pandigit[j] = k;
    }
}
