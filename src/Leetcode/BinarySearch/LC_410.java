package Leetcode.BinarySearch;

public class LC_410 {
    public int splitArray(int[] nums, int m) {
        int l = 0, r = 0;
        // 计算「子数组各自的和的最大值」的上下界
        for (int n : nums) {
            l = Math.max(n, l);
            r += n;
        }
        // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
        // 使得它对应的「子数组的分割数」恰好等于 m
        while (l < r) {
            int mid = l + (r - l) / 2;
            int curSum = 0;
            int split = 1;
            for (int n : nums) {
                if (curSum + n > mid) {
                    split++;
                    curSum = 0;
                }
                curSum += n;
            }
            // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
            // 下一轮搜索的区间是 [mid + 1, right]
            if (split > m) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}
