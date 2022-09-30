package company.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findNumWaysToSplit {
    public static void main(String[] args) {
        findNumWaysToSplit test = new findNumWaysToSplit();
        String s = "abbcac";
        int res = test.solution1(s, 1);
        System.out.println(res);
    }

    public int solution1(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sharedNum = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                sharedNum++;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                sharedNum--;
            }
            if (sharedNum > k) {
                res++;
            }
        }
        return res;
    }


}
