package NG.CodeSignal;

import java.util.*;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/1/22 2:24 PM
 * 4
 */
public class InventoryTracking {
    public static void main(String[] args) {
        String[] logs = new String[]{
                "supply item1 2 100",
                "supply item2 3 60",
                "sell item1 1",
                "sell item1 1",
                "sell item2 2",
                "return item2 1 60 40",
                "sell item2 1",
                "sell item2 1"
        };
        InventoryTracking test = new InventoryTracking();
        System.out.println(Arrays.toString(test.solution(logs)));
    }

    public int[] solution(String[] input) {
        List<Integer> res = new ArrayList<>();

        //Map<itemName, PQ<int[]{Price, amount}>>
        Map<String, PriorityQueue<int[]>> map = new HashMap<>();

        for (String str : input) {
            String[] curOrder = str.split(" ");
            String type = curOrder[0];
            if (type.equals("supply")) {
                String key = curOrder[1];
                Integer amount = Integer.valueOf(curOrder[2]);
                Integer price = Integer.valueOf(curOrder[3]);
                int[] pair = new int[]{price, amount};

                if (!map.containsKey(key)) {
                    map.put(key, new PriorityQueue<>(Comparator.comparingInt(a -> a[0])));
                }
                PriorityQueue<int[]> pq = map.get(key);
                boolean find = false;
                for (int[] p : pq) {
                    if (p[0] == price) {
                        p[1] += amount;
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    pq.add(new int[]{price, amount});
                }
            }
            else if (type.equals("sell")) {
                int gain = 0;
                String key = curOrder[1];
                Integer amount = Integer.valueOf(curOrder[2]);
                PriorityQueue<int[]> pq = map.get(key);
                while (amount > 0) {
                    int[] pair = pq.peek();
                    int price = pair[0];
                    int store = pair[1];

                    int sell = Math.min(amount, store);
                    amount -= sell;
                    store -= sell;
                    gain += sell * price;

                    if (store == 0) {
                        pq.poll();
                    }
                    else {
                        pair[1] = store;
                    }

                }
                res.add(gain);

            }
            else if (type.equals("return")) {
                String key = curOrder[1];
                int amount = Integer.valueOf(curOrder[2]);
                int curPrice = Integer.valueOf(curOrder[4]);

                PriorityQueue<int[]> pq = map.get(key);
                boolean find = false;
                for (int[] pair : pq) {
                    if (pair[0] == curPrice) {
                        pair[1] += amount;
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    pq.offer(new int[]{curPrice, amount});
                }
            }
            else continue;
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;

    }

}
