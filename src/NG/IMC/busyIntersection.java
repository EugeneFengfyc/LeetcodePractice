package NG.IMC;

import java.util.*;

public class busyIntersection {
    public static void main(String[] args) {
        busyIntersection test = new busyIntersection();
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 1, 3, 3));
        List<Integer> str = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1));
        System.out.println(test.solution(arr, str).toString());
    }

    //arrival 0 0 1 4
    //street 0 1 1 0
    //return 2 0 1 4
    public List<Integer> solution(List<Integer> arrival, List<Integer> street) {
        List<Integer> result = new ArrayList<>();
        int[] res = new int[street.size()];
        Queue<Integer[]> ave = new LinkedList<>();
        Queue<Integer[]> main = new LinkedList<>();

        for (int i = 0; i < res.length; i++) {
            if (street.get(i) == 0) main.offer(new Integer[]{i, arrival.get(i)});
            if (street.get(i) == 1) ave.offer(new Integer[]{i, arrival.get(i)});
        }
        int prev = -1;
        int curTime = 0;
        while (!ave.isEmpty() || !main.isEmpty()) {
            //if one of them is empty
            if (ave.isEmpty()) {
                Integer[] curArr = main.poll();
                int index = curArr[0];
                int arrTime = curArr[1];
                if (curTime > arrTime) {
                    res[index] = curTime;
                    curTime++;
                    continue;
                }
                else {
                    curTime = arrTime;
                    res[index] = arrTime;
                    curTime++;
                    continue;
                }
            }

            if (main.isEmpty()) {
                Integer[] curArr = ave.poll();
                int index = curArr[0];
                int arrTime = curArr[1];
                if (curTime > arrTime) {
                    res[index] = curTime;
                    curTime++;
                    continue;
                }
                else {
                    curTime = arrTime;
                    res[index] = arrTime;
                    curTime++;
                    continue;
                }
            }

            //curTime  < both peek time
            Integer[] avePeek = ave.peek();
            Integer[] mainPeek = main.peek();
            int aveIndex = avePeek[0];
             int aveArrTime = avePeek[1];
            int mainIndex = mainPeek[0];
            int mainArrTime = mainPeek[1];

            if (curTime < Math.min(aveArrTime, mainArrTime)) {
                curTime = Math.min(aveArrTime, mainArrTime);
                continue;
            }

            //curTime < one of peek time
            if ((curTime < aveArrTime && curTime >= mainArrTime)) {
                Integer[] curPoll = main.poll();
                res[curPoll[0]] = curTime;
                curTime++;
                prev = 0;
                continue;
            }

            if ((curTime < mainArrTime && curTime >= aveArrTime)) {
                Integer[] curPoll = ave.poll();
                res[curPoll[0]] = curTime;
                curTime++;
                prev = 1;
                continue;
            }

            //curTime > both peek time
            if (curTime >= aveArrTime && curTime >= mainArrTime) {
                if (prev == -1) {
                    Integer[] curPoll = ave.poll();
                    res[curPoll[0]] = curTime;
                    curTime++;
                    prev = 1;
                    continue;
                }
                if (prev == 0) {
                    Integer[] curPoll = main.poll();
                    res[curPoll[0]] = curTime;
                    curTime++;
                    prev = 0;
                    continue;
                }
                if (prev == 1) {
                    Integer[] curPoll = ave.poll();
                    res[curPoll[0]] = curTime;
                    curTime++;
                    prev = 1;
                    continue;
                }
            }

            curTime++;
            prev = -1;

        }
        for (int i = 0; i < res.length; i++) {
            result.add(res[i]);
        }
        return result;
    }
}
