package company.Amazon;

import java.util.*;

public class bestCombos {
    private static List<Integer> res;
    public static void main(String[] args) {
        res = new LinkedList<>();
        int[] input = new int[]{3, 5, -2};
        int k = 3;
        bestCombos test = new bestCombos();
        test.backtrack(input, 0, 0);
        Collections.sort(res, Collections.reverseOrder());
        int[] ans = new int[k];
        for (int i = 0; i < 3; i++) {
            ans[i] = res.get(i);
            System.out.println(ans[i]);
        }
    }

    public void backtrack(int[] nums, int start, int sum) {
        res.add(sum);

        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            backtrack(nums, i + 1, sum);
            sum -= nums[i];
        }
    }
}
