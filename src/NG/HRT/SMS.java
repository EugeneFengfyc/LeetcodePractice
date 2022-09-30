package NG.HRT;

import java.util.ArrayList;
import java.util.List;

public class SMS {
    public static void main(String[] args) {
        String s = "Hello World!";
        //System.out.println(sl(s, 10));
        String[] res = sl(s, 10);
        for (String str: res) {
            System.out.println(str);
        }
    }
    public static String[] sl(String s , int i) {
        int len = s.length();
        List<Integer> l = new ArrayList<>();
        List<Integer> m = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        l.add(0);
        m.add(0);
        a.add(0);
        int n  = 9;
        int k = 5;
        int j = 9;
        int sum = (i - k) * 9;
        l.add(sum);
        m.add(9);
        a.add(5);
        while (sum < 1500) {
            sum -= n;
            j *= 10;
            if (i - k - 2 <= 0) {
                break;
            }
            sum += (i - k - 2) * j;
            n += j;
            l.add(sum);
            m.add(n);
            k += 2;
            a.add(k);
        }
        int index = 0;
        for (; index < l.size(); index++) {
            if (len <= l.get(index)) {
                break;
            }
        }

        int count = m.get(index - 1) + (len - l.get(index - 1)) % (i - k) == 0 ?  (len - l.get(index - 1)) / (i - a.get(index ))  :  (len - l.get(index - 1)) / (i - a.get(index)) + 1;
        String[] res = new String[count];
        int start = 0;
        for (int x =1; x <= count; x++) {
            String suf = "<" + x + "/" + count + ">";
            int length = i - suf.length();
            String pre = s.substring(start , Math.min(s.length(), start + length));
            start += length;
            res[x - 1] = pre + suf;
        }
        return res;
    }




}
