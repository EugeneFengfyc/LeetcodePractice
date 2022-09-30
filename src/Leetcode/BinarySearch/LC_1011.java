package Leetcode.BinarySearch;

//A conveyor belt has packages that must be shipped from one port to another within days days.
//
//  The ith package on the conveyor belt has a weight of weights[i].
//  Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
//  We may not load more weight than the maximum weight capacity of the ship.
// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
//  Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//  Output: 15
//  Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
//  1st day: 1, 2, 3, 4, 5
//  2nd day: 6, 7
//  3rd day: 8
//  4th day: 9
//  5th day: 10
import org.jetbrains.annotations.NotNull;

public class LC_1011 {
    public int shipWithinDays(int @NotNull [] weights, int days) {
        int l = 0, r = 0;
        //find the smallest and bigges capacity first
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        //use binary search on the capacity
        while (l < r) {
            int mid = l + (r - l) / 2;
            //cur: the current loading capacity
            //need: the total days it needs
            //* The initial need should be 1 rather than 0
            int cur = 0;
            int need = 1;
            //traverse all the weights to calculate the
            // total days it needs when the capacity is mid
            for (int w : weights) {
                if (cur + w > mid) {
                    need++;
                    cur = 0;
                }
                cur += w;
            }
            if (need > days) {
                l = mid + 1;
            }
            else {
                //here to find the left boundary of the capacity

                r = mid;
            }
        }
        return l;

    }
}
