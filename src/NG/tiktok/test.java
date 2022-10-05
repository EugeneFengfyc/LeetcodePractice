package NG.tiktok;

import java.util.*;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/4/22 8:32 PM
 * 4
 */
public class test {
    public static int solution(List<Integer> arrivalStations, List<Integer> arrivalTimes,
                              List<Integer> destStations, List<Integer> destTimes, int timeBtwStations) {
        Map<Integer, Deque<Passenger>> map = new HashMap<>();
        int maxTime = 0;
        int maxStation = 0;
        int res = 0;
        for (int i =0; i < arrivalStations.size(); i++) {
            if (!map.containsKey(arrivalStations.get(i))) {
                map.put(arrivalStations.get(i), new LinkedList<>());
            }
            map.get(arrivalStations.get(i)).add(new Passenger(arrivalStations.get(i), arrivalTimes.get(i),
                    destStations.get(i), destTimes.get(i)));
            maxTime = Math.max(maxTime, destTimes.get(i));
            maxStation = Math.max(maxStation, destStations.get(i));
        }
        for (int time = 390;  time <= maxTime / 100 * 60 + maxTime % 100; time += 15) {
            int cur = time;
            Map<Integer, List<Passenger>> train = new HashMap<>();
            int cap = 0;
            for (int i = 1; i <= maxStation; i++) {
                if (train.containsKey(i)) {
                    List<Passenger> tmp = train.get(i);
                    for (Passenger p : tmp) {
                        if (cur > p.dstTime) {
                            res++;
                        }
                        cap--;
                    }
                    train.remove(i);
                }
                cur += 2;
                if (map.containsKey(i)) {
                    Deque<Passenger> tmp = map.get(i);
                    while(!tmp.isEmpty() &&tmp.peekFirst().arrTime <= cur && cap < 5)  {
                        Passenger p = tmp.pollFirst();
                        if (!train.containsKey(p.end)) {
                            train.put(p.end, new ArrayList<>());
                        }
                        train.get(p.end).add(p);
                        cap++;
                    }
                }
                cur += timeBtwStations;
            }
        }
        return res;
    }

    static class Passenger {
        int start ;
        int arrTime;
        int end;
        int dstTime;

        public Passenger(int a, int b , int c , int d) {
            start =a;
            arrTime = help(b);
            end =c;
            dstTime = help(d);
        }

        private int help(int a) {
            return a / 100 * 60 + a % 100;
        }
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,1,1,1,1,1);
        List<Integer> b= Arrays.asList(600, 600, 600, 600, 600, 600);
        List<Integer> c = Arrays.asList(2, 2, 2,2,2,2);
        List<Integer> d = Arrays.asList(645, 645, 645, 645, 645,645);
        int e = 12;
        System.out.println(solution(a, b, c, d, e));
    }
}
