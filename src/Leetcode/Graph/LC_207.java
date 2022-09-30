package Leetcode.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC_207 {
    public static void main(String[] args) {
        LC_207 test = new LC_207();
        String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
        test.groupAnagrams(input);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //这里使用char数组代替排序
            char[] hash = new char[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(s);
        }
        for (String str : map.keySet()) {
            System.out.println(str);
        }
        res.addAll(map.values());
        return res;
    }


}
