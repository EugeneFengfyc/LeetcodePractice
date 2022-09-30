package company.Amazon;

import java.util.Arrays;

public class countPossibleSegments {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6};
        int k = 3;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = i;
            while (r < nums.length) {
                if (nums[r] - nums[i] <= k) {
                    res++;
                }
                System.out.println(nums[i] + " " + nums[r]);
                r = r + 1;
            }
        }
        System.out.println(res);

    }
}
