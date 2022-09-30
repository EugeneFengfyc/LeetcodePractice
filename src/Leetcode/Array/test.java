package Leetcode.Array;

public class test {
    public static void main(String[] args) {
       int a = 10, b = 25, c = 15;
       int res = 0;
       while (b > 0) {
           res += (a % c) + (c % a);
           b -= a % c;
           int temp = c;
           c = a;
           a = temp;
       }
        System.out.println(res);
    }
}
