package NG.CodeSignal;

import java.util.Arrays;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/12/22 3:20 PM
 * 4
 */
public class matrixRotation {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = solution(matrix, new int[]{0, 1, 2});
        for (int[] num : res) {
            System.out.println(Arrays.toString(num));
        }
    }

    public static int[][] solution(int[][] matrix, int[] q) {
        for (int r : q) {
            int n = matrix.length;
            if (r == 0) {
                // 先沿对角线镜像对称二维矩阵
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        // swap(matrix[i][j], matrix[j][i]);
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }
                // 然后反转二维矩阵的每一行
                for (int[] row : matrix) {
                    reverse(row);
                }
            }
            else if (r == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = i; j < n; j++) {
                        // swap(matrix[i][j], matrix[j][i]);
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }
            }
            else if (r == 2) {
                // 沿左下到右上的对角线镜像对称二维矩阵
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - i; j++) {
                        // swap(matrix[i][j], matrix[n-j-1][n-i-1])
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[n - j - 1][n - i - 1];
                        matrix[n - j - 1][n - i - 1] = temp;
                    }
                }
            }
        }
        return matrix;
    }

    public static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
