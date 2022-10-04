package NG.CodeSignal;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/3/22 7:42 PM
 * 4
 */
public class cellToY {
    public static void main(String[] args) {
        int[][] matrix =  {
            {2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}
        };
        cellToY test = new cellToY();
        System.out.println(test.solution(matrix));
    }

    int solution(int[][] matrix) {
        int n = matrix.length;
        int[] count = new int[3];
        int[] sum = new int[3];


        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int cur = matrix[i][j];
                if (cur == 0) count[0]++;
                if (cur == 1) count[1]++;
                if (cur == 2) count[2]++;
            }
        }

        for (int i = n / 2 - 1; i < n; i++) {
            for (int j = n / 2 + 1; j < n; j++) {
                int cur = matrix[i][j];
                if (cur == 0) count[0]++;
                if (cur == 1) count[1]++;
                if (cur == 2) count[2]++;
            }
        }

        for (int i = n / 2; i < n; i++) {
            int cur = matrix[i][n / 2];
            if (cur == 0) count[0]++;
            if (cur == 1) count[1]++;
            if (cur == 2) count[2]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = matrix[i][j];
                if (cur == 0) sum[0]++;
                if (cur == 1) sum[1]++;
                if (cur == 2) sum[2]++;
            }
        }

        for (int i = 0; i < 3; i++) {
            sum[i] -= count[i];
        }

        int maxY = Integer.MIN_VALUE;
        int idxY = 0;
        int idxR = 0;
        for (int i = 0; i < 3; i++) {
            if (count[i] > maxY) {
                maxY = count[i];
                idxY = i;
            }
        }

        int maxR = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (sum[i] > maxR) {
                maxR = sum[i];
                idxR = i;
            }
        }


       if (idxR != idxY) {
           int res = 0;
           for (int i = 0; i < 3; i++) {
               if (count[i] != maxY) {
                   res += count[i];
               }
               if (sum[i] != maxR) {
                   res += sum[i];
               }
           }
           return res;
       }
       else {
           if (idxR == 0) {
               return Math.min(count[0] + count[1] + sum[0] + sum[1], count[0] + count[2] + sum[0] + sum[2]);
           }
           if (idxR == 1) {
               return Math.min(count[1] + count[0] + sum[1] + sum[0], count[1] + count[2] + sum[1] + sum[2]);
           }
           if (idxR == 2) {
               return Math.min(count[2] + count[0] + sum[2] + sum[0], count[2] + count[1] + sum[2] + sum[1]);
           }
       }
       return -1;
    }
}
