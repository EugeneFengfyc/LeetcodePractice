package Leetcode.BinarySearch;

public class LC_162 {
    public static void main(String[] args) {
        LC_162 test = new LC_162();
        int[] nums = {1, 2, 3, 1};
        System.out.println(test.findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
