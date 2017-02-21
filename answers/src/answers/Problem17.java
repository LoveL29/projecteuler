package answers;

/**
 * Created by seok on 2017. 2. 21..
 *
 * Problem 17
 *
 * If the numbers 1 to 5 are written out in words:
 * one, two, three, four, five, then
 * there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive
 * were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example,
 * 342 (three hundred and forty-two) contains 23 letters
 * and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and"
 * when writing out numbers is in compliance with British usage.
 */
public class Problem17 {
    public static void main(String[] args) {
        String underTwenty[] = {"", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};
        String tens[] = {"", "ten", "twenty", "thirty","forty","fifty",
            "sixty","seventy","eighty","ninety"};
        String hundred = "hundred";
        String thousand = "thousand";
        String and = "and";
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 100 < 20) {
                sum += underTwenty[i % 100].length();
            } else {
                sum += underTwenty[i % 10].length();
                sum += tens[(i % 100 - i % 10) / 10].length();
            }
            if (i >= 100 && i < 1000) {
                sum += underTwenty[(i % 1000 - i % 100) / 100].length();
                sum += hundred.length();
                if (i % 100 != 0) {
                    sum += and.length();
                }
            }
            if (i == 1000){
                sum += underTwenty[1].length();
                sum += thousand.length();
            }
        }
        System.out.println(sum);
    }
}
