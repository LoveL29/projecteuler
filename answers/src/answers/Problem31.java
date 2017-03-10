package answers;

/**
 * Created by seok on 2017. 3. 10..
 *
 * Problem 31
 *
 * In England the currency is made up of pound, £, and pence, p,
 * and there are eight coins in general circulation:
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class Problem31 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int sum = 200;
        int[] ways = new int[sum + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                ways[j] += ways[j - coin];
            }
        }
        System.out.println(ways[200]);
    }
}
