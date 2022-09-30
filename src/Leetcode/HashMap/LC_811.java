package Leetcode.HashMap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_811 {
    private static Map<String, Integer> map;
    public static void main(String[] args) {
        map = new HashMap<>();
        String[] cpdomains = new String[]{"9001 discuss.leetcode.com"};
        for (String s : cpdomains) {
            parseDomain(s);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> mapEle : map.entrySet()) {
            String key = mapEle.getKey();
            int val = mapEle.getValue();
            String cur = String.valueOf(val) + " " + key;
            res.add(cur);
        }
        System.out.println(res);

    }
    public static void parseDomain(String s){
        String[] arr = s.split(" ");
        int count = Integer.valueOf(arr[0]);
        String[] domains = arr[1].split("\\.");
        String pre = "";
        for (int i = domains.length - 1; i >= 0; i--) {
            if (domains[i].equals(".")) continue;
            String curStr = "";
            if (pre.equals("")) {
                curStr = domains[i];
            }
            else {
                curStr = domains[i] + "." + pre;
            }
            map.put(curStr, map.getOrDefault(curStr, 0) + count);
            pre = curStr;
        }
    }

}
