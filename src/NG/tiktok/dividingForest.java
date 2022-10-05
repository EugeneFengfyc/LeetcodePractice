package NG.tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/4/22 8:44 PM
 * 4
 */
public class dividingForest {
    public static void main(String[] args) {//1,2,3   2 ,1,2   3,1,1
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> r1 = Arrays.asList(1, 2, 3);
        List<Integer> r2 = Arrays.asList(2, 1, 2);
        List<Integer> r3 = Arrays.asList(3, 1, 1);
        forest.add(r1);
        forest.add(r2);
        forest.add(r3);
        dividingForest test = new dividingForest();
        System.out.println(test.solution(forest, 3));

    }
    public long solution(List<List<Integer>> forest, int k) {
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] sum = new int[m+1][n+1];
        int mod = (int)(1e9+7);

        //post sum
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                sum[i][j]=sum[i+1][j]+sum[i][j+1]-sum[i+1][j+1];//area_A + area_B - (area_A ⋂ area_B)
                sum[i][j]+=forest.get(i).get(j) == 2 ? 1 : 0;
            }
        }

        int[][][] dp = new int[k+1][m][n];
        //base case
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if (sum[i][j] > 0) dp[1][i][j]=1;
            }
        }
        for(int i = 2; i <= k; i++) {
            for(int j = m-1; j >= 0; j--) {
                for(int l = n-1; l >= 0; l--) {
                    for(int x = j+1; x < m; x++) {
                        if (sum[j][l] - sum[x][l] > 0)
                            dp[i][j][l] = (dp[i][j][l] + dp[i-1][x][l])%mod;
                    }
                    for(int x = l+1; x < n; x++) {
                        if (sum[j][l] - sum[j][x] > 0)
                            dp[i][j][l] = (dp[i][j][l] + dp[i-1][j][x])%mod;
                    }
                }
            }
        }

        return dp[k][0][0];
    }

}
