package answers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by seok on 2017. 4. 24..
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * By converting each letter in a word to a number corresponding to
 * its alphabetical position and adding these values we form a word value.
 * For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
 * If the word value is a triangle number then
 * we shall call the word a triangle word.
 * Using words.txt (right click and 'Save Link/Target As...'),
 * a 16K text file containing nearly two-thousand common English words,
 * how many are triangle words?
 *
 */
public class Problem42 {
    // n = (√(1 + 8t) - 1) / 2
    public static void main(String args[]) throws IOException {
        long sum = 0;
        String list[];
        String str = readDataToStr("./data/p042_words.txt");
        str = str.replaceAll("\"", "");
        list = str.split(",");
        Arrays.sort(list);
        int result = 0;
        for (String aList : list) {
            int oneSum = 0;
            for (int j = 0; j < aList.length(); j++) {
                oneSum += (aList.charAt(j) - 'A' + 1);
            }
            double t = (Math.sqrt(8 * oneSum + 1) - 1.0) / 2.0;
            if (t == (int) t) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static String readDataToStr(String file) throws IOException {
        File f = new File(file);
        BufferedReader reader;
        StringBuilder contents = new StringBuilder();
        reader = new BufferedReader(new FileReader(f));
        contents.append(reader.readLine());
        return contents.toString();
    }
}
