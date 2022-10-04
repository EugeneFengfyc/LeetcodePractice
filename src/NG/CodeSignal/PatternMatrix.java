package NG.CodeSignal;

import java.util.*;
import java.util.stream.Collectors;

public class PatternMatrix {
    public static void main(String[] args) {
        int[][] board = {
                {2,4,2,4,2},
                {4,1,4,2,2},
                {1,4,2,5,3}
        };
        char[][] patter = {
                {'4','c'},
                {'c','b'}
        };
        System.out.println(Arrays.toString(new PatternMatrix().solution(board, patter)));
    }

    private int[] solution(int[][] board, char[][] pattern) {
        int m = board.length;
        int n = board[0].length;

        int x = pattern.length;
        int y = pattern[0].length;


        for (int i = 0; i <= m - x; i++) {
            for (int j = 0; j <= n - y; j++) {
                // upper left point
                boolean flag = true;
                Map<Character,Integer> map = new HashMap<>();

                for (int a = 0; a < x && flag; a++) {
                    for (int b = 0; b < y; b++) {
                        char ch = pattern[a][b];

                        if (Character.isDigit(ch)) {
                            if ((ch - '0') != board[a + i][b + j]) {
                                flag = false;
                                break;
                            }
                        }

                        if (!Character.isDigit(ch)) {
                            if (map.containsKey(ch)) {
                                if (map.get(ch) != board[a + i][b + j]) {
                                    flag = false;
                                    break;
                                }
                            } else {
                                Set<Integer> temp = new HashSet<>(map.values());
                                if (temp.contains(board[a + i][b + j])) {
                                    flag = false;
                                    break;
                                }
                                map.put(ch, board[a + i][b + j]);
                            }
                        }
                    }
                }

                if (flag) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
