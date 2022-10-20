package NG.tiktok;

import java.util.Arrays;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/17/22 5:06 PM
 * 4
 */
public class MinimumUniqueArraySum {
    public static void main(String[] args) {
        int[] test1 = new int[]{3, 2, 1, 2, 7};
        int[] test2 = new int[]{2, 2, 2};
        System.out.println("test1: " + solution(test1));
        System.out.println("test2: " + solution(test2));
    }
    private static int solution(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = nums[0];
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (prev >= cur) {
                cur = prev + 1;
            }
            sum += cur;
            prev = cur;
        }
        return sum;
    }
}
