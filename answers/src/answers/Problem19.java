package answers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringJoiner;

/**
 * Created by seok on 2017. 2. 24..
 *
 * Problem 19
 *
 * https://projecteuler.net/problem=19
 */
public class Problem19 {
    public static void main(String[] args) throws ParseException {
        long result = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        Date startDate = dateFormat.parse("19000101");
        Date endDate = dateFormat.parse("19000201");
        Date lastDate = dateFormat.parse("20001231");
        int year = 1900;
        int month = 2;
        while (endDate.getTime() < lastDate.getTime()) {
            if (((endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000)) % 7 == 6) {
                result++;
            }
            month++;
            if (month == 13) {
                year++;
                month = 1;
            }
            if (month < 10) {
                endDate = dateFormat.parse(String.valueOf(year) + "0" + String.valueOf(month) + "01");
            } else {
                endDate = dateFormat.parse(String.valueOf(year) + String.valueOf(month) + "01");
            }
        }
        System.out.println(result);
    }
}
