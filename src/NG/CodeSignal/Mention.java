package NG.CodeSignal;

import java.util.*;

public class Mention {

    public static void main(String[] args) {
        String[] members = {"id123", "id234", "id7", "id321", "id111"};
        String[] messages = {
                "Hey @id123,id321 review this PR please @id111 @id111",
                "Hey @id7 nice appro@ch! Great job! @id800 @id111",
                "@id123,id321 thx!"
        };
        System.out.println(Arrays.toString(new Mention().solution(members, messages)));
    }

    /** ---- bro 从这里开始写 忽略上面 ---- **/
    class MyPair {
        String id;
        Integer freq;

        MyPair(String i, Integer f) {
            id = i;
            freq = f;
        }
    }

    private String[] solution(String[] members, String[] messages) {
        int n = members.length;
        String[] res = new String[n];

        Set<String> memberSet = new HashSet<>();
        Map<String,Integer> freqMap = new HashMap<>();

        for (String member : members) {
            memberSet.add(member);
            freqMap.put(member, 0);
        }

        for (String message : messages) {
            String[] words = message.split(" ");
            Set<String> visited = new HashSet<>();

            for (String word : words) {
                if (!word.startsWith("@id")) {
                    continue;
                }

                word = word.substring(1);

                String[] ids = word.split(",");
                for (String id : ids) {
                    if (!memberSet.contains(id) || visited.contains(id)) {
                        continue;
                    }

                    visited.add(id);
                    freqMap.put(id, freqMap.get(id) + 1);
                }
            }
        }

        PriorityQueue<MyPair> pq = new PriorityQueue<>(
                (a, b) -> a.freq == b.freq ? a.id.compareTo(b.id) : b.freq - a.freq
        );

        for (String id : freqMap.keySet()) {
            pq.offer(new MyPair(id, freqMap.get(id)));
        }

        int i = 0;
        while (!pq.isEmpty()) {
            MyPair pair = pq.poll();
            res[i++] = pair.id + "=" + pair.freq;
        }

        return res;
    }
}
