package Leetcode.BinarySearch;

public class LC_1482 {
    public static void main(String[] args) {
        LC_1482 test = new LC_1482();
        int[] nums = new int[]{1, 10, 3, 10 ,2};
        int m = 3, k = 1;
        System.out.println(test.minDays(nums, m, k));
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int l = 1, r = 0;
        for (int b : bloomDay) {
            r = Math.max(b, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int curBq = 0;
            int sum = 0;
            for (int b : bloomDay) {

                if (b <= mid) {
                    curBq++;
                }
                else {
                    curBq = 0;
                }
                //注意： 这里
                if (curBq == k) {
                    sum++;
                    curBq = 0;
                }
            }

            if (sum < m) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        return l;
    }
}
