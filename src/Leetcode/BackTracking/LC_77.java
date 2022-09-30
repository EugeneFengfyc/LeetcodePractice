package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC_77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        LC_77 test = new LC_77();
        test.combine(4, 2);
    }
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1);
        return res;

    }

    public void helper(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            helper(n, k, i + 1);
            path.removeLast();
        }
    }
}
