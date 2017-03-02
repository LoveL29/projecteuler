package answers;

import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;

import java.math.BigInteger;

/**
 * Created by seok on 2017. 3. 2..
 *
 * Problem 25
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * What is the index of the first term
 * in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 {
    public static void main(String[] args) {
        String maxStr = "1";
        while (maxStr.length() < 1000) {
            maxStr += "0";
        }
        BigInteger max = new BigInteger(maxStr);
        int count = 2;
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        while (a.compareTo(max) < 0) {
            a = b.add(c);
            b = c;
            c = a;
            count++;
        }
        System.out.println(count);
    }
}
