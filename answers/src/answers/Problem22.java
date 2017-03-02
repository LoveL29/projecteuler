package answers;

import java.io.*;
import java.util.Arrays;

/**
 * Created by seok on 2017. 2. 27..
 *
 * Problem 22
 *
 * Using names.txt, a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position
 * in the list to obtain a name score.
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list. So,
 * COLIN would obtain a score of 938 × 53 = 49714.
 * What is the total of all the name scores in the file?
 */
public class Problem22 {
    public static void main(String[] args) throws IOException {
        long sum = 0;
        File f = new File("./data/names.txt");
        BufferedReader reader;
        String list[];
        StringBuilder contents = new StringBuilder();
        reader = new BufferedReader(new FileReader(f));
        contents.append(reader.readLine());
        String str = contents.toString();
        str = str.replaceAll("\"", "");
        list = str.split(",");
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            long oneSum = 0;
            for(int j = 0; j < list[i].length(); j++) {
                oneSum += (list[i].charAt(j) - 'A' + 1);
            }
            sum += oneSum * (i + 1);
        }
        System.out.println(sum);
    }
}
