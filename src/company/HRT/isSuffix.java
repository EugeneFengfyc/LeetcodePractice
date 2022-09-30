package company.HRT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class isSuffix {
    public static void main(String[] args) {
        isSuffix test = new isSuffix();
        String[] input = new String[]{"back", "backdoor", "gammon", "backgammon", "comeback", "come", "door"};
        System.out.println(test.solution(input));

    }
    public int solution(String[] input) {
        //判断字符串数组里有多少是suffix pair，或者相等是相等对pair
        int res = 0;
        int equal = 0;
        Set<String> set = new HashSet();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) continue;
                if (input[i].equals(input[j])) {
                    set.add(input[i]);
                    equal++;
                    res++;
                    continue;
                }
                if (isValid(input[i], input[j])) {
                    res++;
                }
            }
        }
        return res - (equal / 2);
    }
    public boolean isValid(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2)
            return false;
        for (int i = 0; i < n1; i++)
            if (s1.charAt(n1 - i - 1) != s2.charAt(n2 - i - 1))
                return false;
        return true;
    }
}
