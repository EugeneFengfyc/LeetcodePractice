package NG.CodeSignal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/9/22 8:00 PM
 * 4
 */
public class ServersRequest {

    int[] time;
    int[] res;
    public static void main(String[] args) {
        String[] events = new String[]{
                "REQUEST",
                "REQUEST",
                "UP 1",
                "REQUEST",
                "REQUEST",
                "REQUEST",
                "REQUEST",
        };

        ServersRequest test = new ServersRequest();
        System.out.println(test.solution(4, 1, 3, events));

    }

    private int solution(int nServers, int workLimit, int recoveryTime, String[] events) {
        time = new int[nServers];
        res = new int[nServers];
        int max = Integer.MIN_VALUE;
        Queue<server> que = new LinkedList<>();
        for (int i = 0; i < nServers; i++) {
            que.offer(new server(i, false, 0));
        }
        for (String e : events) {
            if (e.equals("REQUEST")) {
                while (!que.isEmpty()) {
                    server cur = que.poll();
                    if (cur.recover == true || cur.load == workLimit) {
                        que.offer(cur);
                    }
                    else {
                        cur.load++;
                        res[cur.id]++;
                        max = Math.max(res[cur.id], max);
                        if (cur.load == workLimit) {
                            time[cur.id] += recoveryTime;
                            cur.recover = true;
                        }
                        que.offer(cur);
                        for (int i = 0; i < time.length; i++) {
                            if (i != cur.id && time[i] != 0) {
                                time[i]--;
                            }
                        }
                        break;
                    }

                }
            }

            else {
                String[] cur = e.split(" ");
                int idx = Integer.valueOf(cur[1]);
                for (server s : que) {
                    if (s.id == idx) {
                        s.recover = false;
                        time[s.id] = 0;
                    }
                }
            }
        }

        for (int j = res.length - 1; j >= 0; j--) {
            if (res[j] == max) {
                return res[j];
            }
        }
        return -1;

    }

    class server {
        int id;
        boolean recover;
        int load;

        public server(int id, boolean recover, int load) {
            this.id = id;
            this.recover = recover;
            this.load = load;
        }
    }
}