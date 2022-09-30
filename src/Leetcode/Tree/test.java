package Leetcode.Tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test
    {
        public static void main(String[] args) {
            test A = new test();
            int[] locations = new int[]{1, 7, 6, 8};
            int[] start = new int[]{1, 7, 2};
            int[] end = new int[]{2, 9, 5};
            A.move(start, end, locations);
            System.out.println(Arrays.toString(locations));
        }
        public void move(int[] start, int[] end, int[] loc) {
            for (int i = 0; i< start.length; i++) {
                for (int j = 0; j < loc.length; j++) {
                    if (loc[j] == start[i]) {
                        loc[j] = end[i];
                    }
                }
            }
            Arrays.sort(loc);
        }
    }


