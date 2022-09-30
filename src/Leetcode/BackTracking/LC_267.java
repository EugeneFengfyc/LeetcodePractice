package Leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_267 {
    Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        LC_267 test = new LC_267();
        List<String> res = new ArrayList<>();
        res = test.generatePalindromes("aabb");
        for (String s : res) {
            System.out.println(s);
        }
    }

    public List<String> generatePalindromes(String s) {
        dfs(s, new StringBuilder());
        List<String> list = new ArrayList<>(set);
        return list;
    }
    public void dfs(String s, StringBuilder sb) {
        String cur = sb.toString();
        if (cur.length() == s.length() && isPalindrome(cur)) {
            set.add(cur);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            dfs(s, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
