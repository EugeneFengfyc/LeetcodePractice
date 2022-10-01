package NG.CodeSignal;

import java.util.*;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/1/22 2:24 PM
 * 4
 */
public class InventoryTracking {
    public static void main(String[] args) {

    }

    public int[] solution(String[] input) {
        List<Integer> res = new ArrayList<>();
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        Map<Integer, Integer> priceMap = new HashMap<>();

        for (String str : input) {
            String[] curOrder = str.split(" ");
            String type = curOrder[0];
            if (type.equals("supply")) {
                String key = curOrder[1];
                Integer amount = Integer.valueOf(curOrder[2]);
                Integer price = Integer.valueOf(curOrder[3]);

                if (!map.containsKey(key)) {
                    map.put(key, new PriorityQueue<>());
                }
                map.get(key).add(price);
                priceMap.put(price, priceMap.getOrDefault(price, 0) + amount);
            }
            else if (type.equals("sell")) {
                String key = curOrder[1];
                Integer amount = Integer.valueOf(curOrder[2]);
                PriorityQueue<Integer> pq = map.get(key);
                while (!pq.isEmpty()) {
                    int curPrice = pq.poll();
                    int curAmount = priceMap.get(curPrice);
                    if (curAmount > amount) {
                        curAmount -= amount;
                        priceMap.put(curPrice, curAmount);
                        res.add(curAmount * curPrice);
                    }
                    else {

                    }
                }

            }
            else if (type.equals("return")) {

            }
            else continue;
        }
        return new int[]{};
    }

}
