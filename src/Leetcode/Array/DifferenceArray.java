package Leetcode.Array;

public class DifferenceArray {
    private int[] diff;

    public DifferenceArray(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return  res;
    }
    public static void main(String[] args) {
        DifferenceArray test = new DifferenceArray(new int[]{1, 2, 3, 4, 5});
        test.increment(1, 3, 3);
        for(int i : test.result()) {
            System.out.println(i);
        }
    }
}
