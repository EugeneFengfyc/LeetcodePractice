package Leetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_18 {
    public static void main(String[] args) {
        LC_18 test = new LC_18();
        int target = 0;
        int[] num = {1, 0, -1, 0, 2, -2};


    }
    public List<List<Integer>> solution(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        if (len < 2 || len > n) return res;
        if (len == 2) {
            int l = start;
            int r = len - 1;
            while (l < r) {
                int curSum = nums[l] + nums[r];
                if (curSum < target) {
                    l++;
                }
                else if (curSum > target) {
                    r--;
                }
                else {

                }
            }
        }
        else {

        }




        return res;
    }

}
