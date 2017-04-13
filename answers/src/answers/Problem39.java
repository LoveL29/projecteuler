package answers;

/**
 * Created by seok on 2017. 4. 13..
 *
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.
 * {20,48,52}, {24,45,51}, {30,40,50}
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem39 {
    public static void main(String args[]) {
        // a^2 + b^2 == c^2 && a + b + c = p
        // => b = p(p - 2a) / 2(p - a)
        int result = 0;
        int mostSolutions = 0;
        for (int p = 2; p <= 1000; p++) {
            int solutions = 0;
            for (int a = 2; a < (p / 3); a++) {
                if (p * (p - 2 * a) % (2 * (p - a)) == 0) {
                    solutions++;
                }
            }
            if(solutions > mostSolutions){
                mostSolutions = solutions;
                result = p;
            }
        }
        System.out.println(result);
    }
}
