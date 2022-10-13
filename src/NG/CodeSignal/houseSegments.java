package NG.CodeSignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/12/22 3:34 PM
 * 4
 */
public class houseSegments {
    public static void main(String[] args) {
        int[] house = new int[]{2, 4, 5, 6, 7};
        int[] q = new int[]{5, 6, 2};
        System.out.println(Arrays.toString(solution(house, q)));
    }
    public static int[] solution(int[] houses, int[] queries) {

        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int h : houses) {
            max = Math.max(max, h);
            min = Math.min(min, h);
        }

        int[] copy = new int[max + 1];
        int[] copy2 = new int[min + 1];
        Arrays.fill(copy, Integer.MAX_VALUE);
        Arrays.fill(copy2, Integer.MAX_VALUE);
        for (int h : houses) {
            if (h >= 0) copy[h] = 1;
            if (h < 0) copy2[Math.abs(h)] = 1;
        }

        for (int q : queries) {
            copy[q] = 0;
            int count = 0;
            int i = 0, j = 0;
            while (j < copy.length) {
               if (copy[i] == 1) {
                   while (j < copy.length && copy[j] == 1) {
                       j++;
                   }
                   count++;
                   i = j;
               }
               else {
                   i++;
                   j = i;
               }
            }

            int k = 0, z = 0;
            //paste
            while (z < copy.length) {
                if (copy[k] == 1) {
                    while (z < copy.length && copy[z] == 1) {
                        z++;
                    }
                    count++;
                    k = z;
                }
                else {
                    k++;
                    z = k;
                }
            }

            res.add(count);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
