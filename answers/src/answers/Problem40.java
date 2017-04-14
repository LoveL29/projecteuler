package answers;

/**
 * Created by seok on 2017. 4. 14..
 *
 * An irrational decimal fraction is created
 * by concatenating the positive integers:
 * 0.12345678910'1'112131415161718192021...
 * It can be seen that the 12th digit of the fractional part is 1.
 * If dn represents the nth digit of the fractional part,
 * find the value of the following expression.
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem40 {
    public static void main(String args[]) {
        int result = 1;
        StringBuilder champernowne = new StringBuilder();
        for (int i = 1; i < 1000000; i++) {
            champernowne.append(i);
        }
        for (int d = 1; d <= 1000000; d *= 10) {
            result *= champernowne.charAt(d - 1) - '0';
        }
        System.out.println(result);
    }
}
