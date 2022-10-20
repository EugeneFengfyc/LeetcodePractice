package NG.CodeSignal;

import java.util.*;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/19/22 8:28 PM
 * 4
 */
public class MemoAllocation {
    public static void main(String[] args) {
        int[] memo = new int[]{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0};
        int[][] q = new int[][]{{0, 2}, {0, 1}, {0, 1}, {1, 2}, {1, 4}, {0, 4}};
        System.out.println(Arrays.toString(solutions(memo, q)));

    }

    public static int[] solutions(int[] memo, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int counter = 1;
        for (int[] q : queries) {
            if (q[0] == 0) {
                int len = q[1];
                int i = 0, j = i + len - 1;
                if (j >= memo.length) {
                    res.add(-1);
                }
                else {
                    boolean valid = false;
                    while (i < memo.length && j < memo.length) {
                        int count = 0;
                        for (int k = i; k <= j; k++) {
                            if (memo[k] == 0) count++;
                        }
                        if (count == j - i + 1) {
                            for (int k = i; k <= j; k++) {
                                memo[k] = 1;
                            }
                            res.add(i);
                            valid = true;
                            map.put(counter, new int[]{i, j});
                            counter++;
                            System.out.println(Arrays.toString(memo));
                            break;

                        }
                        else {
                            i++;
                            j++;
                        }
                    }
                    if (valid == false) {
                        res.add(-1);
                        System.out.println(Arrays.toString(memo));
                        break;
                    }

                }

            }
            else if (q[0] == 1) {
                int id = q[1];
                if (!map.containsKey(id)) {
                    res.add(-1);
                    System.out.println(Arrays.toString(memo));
                }
                else {
                    int[] nums = map.get(id);
                    int start = nums[0];
                    int end = nums[1];
                    for (int i = start; i <= end; i++) {
                        memo[i] = 0;
                    }
                    res.add(end - start + 1);
                    System.out.println(Arrays.toString(memo));
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
