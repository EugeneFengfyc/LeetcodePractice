package Leetcode.BinarySearch;

public class test {
    public static void main(String[] args) {
        test a = new test();
        int[] nums = {1, 2, 2, 2, 2, 3};
        System.out.println(a.left(nums, 2));
    }
    public int left(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (target == nums[mid]) {
                right = mid - 1;
            }else if (target < nums[mid]) {
                right = mid - 1;
            }else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        if (left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
}


