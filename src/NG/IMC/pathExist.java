package NG.IMC;

import java.util.*;

public class pathExist {
    public static void main(String[] args) {
        pathExist test = new pathExist();
        System.out.println(test.ifExist(1, 1, 1, 5, 4));
    }
    public boolean checkSquare(int n) {
        if (n == 1) return false;
        double res = Math.sqrt(n);
        return (res - Math.floor(res) == 0);
    }
    public boolean ifExist(int c, int x1, int y1, int x2, int y2) {
        if (checkSquare(x2 + y2)) return false;
        if (x1 == x2 && y1 == y2) return true;
        if (x1 > x2 || y1 > y2) return false;

        boolean ans1 = false, ans2 =false, ans3 = false;
        if (!checkSquare(x2 + y2 - c -c)) {
            ans1 = ifExist(c, x1, y1, x2 - c, y2 - c);
        }

        if (x2 > y2) {
            if (!checkSquare(x2)) {
               ans2 = ifExist(c, x1, y1, x2 - y2, y2);
            }
        }

        if (x2 < y2) {
            if (!checkSquare(y2)) {
                ans3 = ifExist(c, x1, y1, x2, y2 - x2);
            }
        }
        return (ans1 || (ans2 || ans3)) ? true:false;
    }

}
