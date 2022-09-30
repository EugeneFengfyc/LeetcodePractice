package Leetcode;

public class DSA {
    public static void main(String[] args) {
        DSA test = new DSA();
        System.out.println(test.result(5));
    }

    public int result(int n) {
        if(n == 1)
            return 2;
        else
            return 2 * result(n-1);
    }
}

