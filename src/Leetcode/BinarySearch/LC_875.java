package Leetcode.BinarySearch;

public class LC_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p : piles) {
            r = Math.max(p, r);
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            int need = 0;
            for (int p : piles) {
                need += p / mid;
                if (p % mid > 0)
                    need++;
            }
            if (need > h) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}
