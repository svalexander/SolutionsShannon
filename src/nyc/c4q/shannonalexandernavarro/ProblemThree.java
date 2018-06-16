package nyc.c4q.shannonalexandernavarro;

import java.util.Arrays;

/**
 * Created by shannonalexander-navarro on 6/16/18.
 */
public class ProblemThree {

    public static int changePossibilities(int amount, int[] denominations) {

        int count = 0;
        int iterations = 0;

        if (amount == 0) {
            count++;
        } else {
            for (int current : denominations) {
                int[] subArry = Arrays.copyOfRange(denominations, iterations, denominations.length);
                if (amount >= current) {
                    count += changePossibilities(amount - current, subArry);
                    iterations++;
                }
            }
        }
        return count;
    }
}
