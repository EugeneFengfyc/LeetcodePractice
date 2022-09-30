package Leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 */
public class LC_15 {
    public static void main(String[] args) {
        LC_15 test = new LC_15();
        int[] nums = {1, 0, -1, 0, 2, -2};
        int target = 0;
        System.out.println(test.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        // sort the array
        Arrays.sort(nums);
        // if nums[i] > 0, the sum cannot be 0
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // two avoid the duplicates
            if (i == 0 || nums[i] != nums[i - 1]) {
                sumHelper(nums, i, res);
            }
        }
        return res;
    }
    public void sumHelper(int[] nums, int flag, List<List<Integer>> res) {

        int low = flag + 1, high = nums.length - 1;
        while (low < high) {
            int curSum = nums[flag] + nums[low] + nums[high];
            if (curSum < 0) {
                low++;
            }
            else if (curSum > 0) {
                high--;
            }
            else {
                // if sum is 0, the low++, high--
                res.add(Arrays.asList(nums[flag], nums[low++], nums[high--]));
                // avoid duplicates
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            }
        }
    }
}
