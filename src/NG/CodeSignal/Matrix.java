package NG.CodeSignal;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,0,1},
                {2,1,2},
                {0,2,2}

//                {1,0,2},
//                {1,2,0},
//                {0,2,0}
//                {2,0,0,0,2},
//                {1,2,1,2,0},
//                {0,1,2,1,0},
//                {0,0,2,1,1},
//                {1,1,2,1,1}
        };

        System.out.println("result = " + new Matrix().solution(matrix));
    }

    private int solution(int[][] matrix) {
        int n = matrix.length;
        int center = n / 2; // 5/2 = 2
        boolean[][] yArr = new boolean[n][n];

        int[] diag = new int[3]; // 0 1 2
        for (int i = 0; i <= center; i++) {
            yArr[i][i] = true;
            diag[matrix[i][i]]++;
        }

        System.out.println(Arrays.toString(diag));

        int[] antiDiag = new int[3];
        for (int i = center; i >= 0; i--) {
            yArr[i][n - i - 1] = true;
            antiDiag[matrix[i][n - i - 1]]++;
        }

        System.out.println(Arrays.toString(antiDiag));

        int[] vertical = new int[3];
        for (int i = center; i < n; i++) {
            yArr[i][center] = true;
            vertical[matrix[i][center]]++;
        }

        System.out.println(Arrays.toString(vertical));

        int num0 = diag[0] + antiDiag[0] + vertical[0] - (matrix[center][center] == 0 ? 2 : 0);
        int num1 = diag[1] + antiDiag[1] + vertical[1] - (matrix[center][center] == 1 ? 2 : 0);
        int num2 = diag[2] + antiDiag[2] + vertical[2] - (matrix[center][center] == 2 ? 2 : 0);

        System.out.println("numY 0 = " + num0);
        System.out.println("numY 1 = " + num1);
        System.out.println("numY 2 = " + num2);

        int[] background = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (yArr[i][j]) {
                    continue;
                }

                background[matrix[i][j]]++;
            }
        }

        int numBack0 = background[0];
        int numBack1 = background[1];
        int numBack2 = background[2];

        System.out.println("numBack 0 = " + numBack0);
        System.out.println("numBack 1 = " + numBack1);
        System.out.println("numBack 2 = " + numBack2);

        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        if (num0 >= Math.max(num1, num2)) {
            if (numBack1 >= numBack2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!yArr[i][j] && matrix[i][j] != 1) {
                            cnt0++;
                        }
                        if (yArr[i][j] && matrix[i][j] != 0) {
                            cnt0++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!yArr[i][j] && matrix[i][j] != 2) {
                            cnt0++;
                        }
                        if (yArr[i][j] && matrix[i][j] != 0) {
                            cnt0++;
                        }
                    }
                }
            }
        }

        if (num1 >= Math.max(num0, num2)) {
            if (numBack0 >= numBack2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!yArr[i][j] && matrix[i][j] != 0) {
                            cnt1++;
                        }
                        if (yArr[i][j] && matrix[i][j] != 1) {
                            cnt1++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!yArr[i][j] && matrix[i][j] != 2) {
                            cnt1++;
                        }
                        if (yArr[i][j] && matrix[i][j] != 1) {
                            cnt1++;
                        }
                    }
                }
            }
        }

        if (num2 >= Math.max(num0, num1)) {
            if (numBack0 >= numBack1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!yArr[i][j] && matrix[i][j] != 0) {
                            cnt2++;
                        }
                        if (yArr[i][j] && matrix[i][j] != 2) {
                            cnt2++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!yArr[i][j] && matrix[i][j] != 1) {
                            cnt2++;
                        }
                        if (yArr[i][j] && matrix[i][j] != 2) {
                            cnt2++;
                        }
                    }
                }
            }
        }

        System.out.println("count = " + cnt0 + "," + cnt1 + "," + cnt2);

        if (cnt0 == 0 && cnt1 == 0 && cnt2 == 0) {
            return 0;
        }

        if (cnt0 == 0 && cnt1 == 0) {
            return cnt2;
        }

        if (cnt0 == 0 && cnt2 == 0) {
            return cnt1;
        }

        if (cnt1 == 0 && cnt2 == 0) {
            return cnt0;
        }

        if (cnt0 == 0) {
            return Math.min(cnt1, cnt2);
        }

        if (cnt1 == 0) {
            return Math.min(cnt0, cnt2);
        }

        if (cnt2 == 0) {
            return Math.min(cnt0, cnt1);
        }

        return Math.min(Math.min(cnt0, cnt1), cnt2);

//        return cnt0 == 0 ? (cnt1 == 0 ? cnt2 : cnt1) : cnt0;
    }
}
