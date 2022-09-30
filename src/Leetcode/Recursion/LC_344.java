package Leetcode.Recursion;

public class LC_344 {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd'};
        LC_344 test = new LC_344();
        test.reverseStr(s);
        System.out.println(s);
    }
    public void reverseStr(char[] s) {
        helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i++] = s[j];
        s[j--] = temp;
        helper(s, i, j);
    }
}

