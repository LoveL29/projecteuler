package answers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seok on 2018. 1. 11..
 *
 * Problem 52
 * It can be seen that the number, 125874,
 * and its double, 251748, 
 * contain exactly the same digits, but in a different order.
 * Find the smallest positive integer, x, such 
 * that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 */
public class Problem52 {
    public static void main(String args[]) {
        long result = 0;
		for (int i = 10; i < 300000; i++) {
        	if ((compareNumbers(i, i * 2))
        		&& (compareNumbers(i, i * 3))
        		&& (compareNumbers(i, i * 4))
        		&& (compareNumbers(i, i * 5))
        		&& (compareNumbers(i, i * 6))) {
				result = i;
            	break;
			}
		}
        System.out.println(result);
    }

	private boolean compareNumbers(long num1, long num2) {
		String str1 = String.valueOf(num1);
		String str2 = String.valueOf(num2);

		if (str1.length() != str2.length()) {
        	return false;
    	}

		int[] array1 = new int[10];
		int[] array2 = new int[10];

		for (int i = 0; i < s.length(); i++) {
			array1[Integer.parseInt(str1.charAt(i))]++;
			if (array1[Integer.parseInt(str1.charAt(i))] > 1) {
				return false;
			}
			array2[Integer.parseInt(str2.charAt(i))]++;
			if (array2[Integer.parseInt(str2.charAt(i))] > 1) {
				return false;
			}
		}
		if (Arrays.equals(array1, array2)) {
			return true;
		}
		return false;
	}
}
