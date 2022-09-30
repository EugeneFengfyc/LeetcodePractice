package NG.circle;

import java.sql.SQLOutput;

public class MatrixFall {
    int n;
    int m;
    char[][] matrix;
    public char[][] solution(char[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int min = n;
        this.matrix = matrix;
        for (int i =0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'F') {
                    min = Math.min(find(i, j), min);
                }
            }
        }
        if (min ==0) {
            return matrix;
        }

        for (int i = n -1; i >=0; i--) {
            for (int j = m -1; j>=0; j--) {
                if (matrix[i][j] == 'F') {
                    matrix[i + min][j] = 'F';
                    matrix[i][j] = '.';
                }
            }
        }
        return matrix;
    }

    private int find(int i, int j ) {
        int res = 0;
        while (i + res < n && matrix[i+res][j] != '#') {
            res++;
        }
        return --res;
    }

    public static void main(String[] args) {
        MatrixFall sl = new MatrixFall();
        char[][] matrix= new char[][]{{'F', 'F', 'F'},{'.','F','.'},{'.','F','F'},{'#','F','.'},{'F','F','.'},{'.','.','.'},{'.','.','#'},{'.','.','.'}};
        for (char[] m : matrix) {
            System.out.println(new String(m));
        }
        System.out.println("------------------------------------");
        char[][] res = sl.solution(matrix);
        int a = 0;
        for (char[] r : res) {
            System.out.println(new String(r));
        }
    }
}