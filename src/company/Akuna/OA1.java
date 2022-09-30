package company.Akuna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class OA1 {
    public static void main(String[] args) {
        int[][] bids = new int[][]{{1, 5, 5, 0}, {2, 7, 8, 1}, {3, 7 ,5 ,1}, {4, 10, 3, 3}};
        int totalShares = 18;
        OA1 test = new OA1();
        List<Integer> res = test.solution(bids, totalShares);
        for (int r : res) System.out.println(r);

    }

    public List<Integer> solution(int[][] bids, int totalShares) {
        class Bid {
            int id, share, price, time;
            Bid(int id, int share, int price, int time) {
                this.id = id;
                this.share = share;
                this.price = price;
                this.time = time;
            }
        }
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, PriorityQueue<Bid>> map = new HashMap<>();
        PriorityQueue<Integer> price = new PriorityQueue<>((a,b) -> b - a);

        for (int i = 0; i < bids.length; i++) {
            if (!map.containsKey(bids[i][2])) {
                PriorityQueue<Bid> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
                map.put(bids[i][2], pq);
            }
            Bid curBid = new Bid(bids[i][0], bids[i][1], bids[i][2], bids[i][3]);
            if (!price.contains(bids[i][2])) price.add(bids[i][2]);
            PriorityQueue<Bid> pq = map.get(bids[i][2]);
            pq.add(curBid);
        }

        while (totalShares > 0) {
            int curPrice = price.poll();
            PriorityQueue<Bid> pq = map.get(curPrice);
            if (totalShares > pq.size()) {
                List<Bid> list = new ArrayList<>();
                list.addAll(pq);
                int sum = 0;
                for (Bid b : list) {
                    sum += b.share;
                }
                if (totalShares >= sum) {
                    totalShares -= sum;
                }
                else {
                    break;
                }
            }
            else {
                while (!pq.isEmpty()) {
                    if (totalShares > 0) {
                        pq.poll();
                        totalShares--;
                    }
                    else {
                        res.add(pq.poll().id);
                    }
                }

                while (!price.isEmpty()) {
                    int nextPrice = price.poll();
                    PriorityQueue<Bid> nextPq = map.get(nextPrice);
                    while (!nextPq.isEmpty()) {
                        res.add(nextPq.poll().id);
                        return res;
                    }
                }
            }
        }
        while (!price.isEmpty()) {
            int nextPrice = price.poll();
            PriorityQueue<Bid> nextPq = map.get(nextPrice);
            while (!nextPq.isEmpty()) {
                res.add(nextPq.poll().id);
                return res;
            }
        }

        return res;


    }



}
