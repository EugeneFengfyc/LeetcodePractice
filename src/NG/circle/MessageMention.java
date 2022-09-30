package NG.circle;

import java.util.*;

public class MessageMention {
    public static void main(String[] args) {
        String[] msg = new String[]{
                "hey @id123,id321 fasdf @id123",
                "hey @id8",
                "@id123,id321"
        };
        List<String> members = new ArrayList<>();
        members.add("123");
        members.add("321");
        members.add("7");
        members.add("8");

        MessageMention mm = new MessageMention();
        System.out.println(mm.solution(members, msg).toString());
    }

    List<String> solution(List<String> members, String[] msg) {
        Map<String, Integer> map = new HashMap<>();
        for (String m : members) {
            map.put(m, 0);
        }
        for (String str : msg) {
            String[] array = str.split(" ");
            Set<String> set = new HashSet<>();
            for (String s : array) {
                if (s.startsWith("@id")) {
                    String[] curArray = s.split(",");
                    for (int i = 0; i < curArray.length; i++) {
                        String cur = curArray[i];
                        if (i == curArray.length - 1) {
                            if (!Character.isDigit(cur.charAt(cur.length() - 1))) {
                                set.add(cur.substring(2, cur.length() - 1));
                            }
                            else {
                                set.add(cur.substring(2));
                            }
                        }
                        else if (i == 0) {
                            set.add(cur.substring(3));
                        }
                        else {
                            set.add(cur.substring(2));
                        }
                    }
                }
            }
            for (String curStr : set) {
                if (map.containsKey(curStr)) {
                    map.put(curStr, map.get(curStr) + 1);
                }
            }



        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(new String(entry.getKey() + ": " + entry.getValue()));
        }
        return res;
    }


}
