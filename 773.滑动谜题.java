
/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */
import java.util.*;

// @lc code=start
class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = board.length, n = board[0].length;
        StringBuilder sb = new StringBuilder();
        String target = "123450";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        // neighbor[i]为下表为i的字符的相邻字符的索引
        int[][] neighbor = new int[][] {
                { 1, 3 },
                { 0, 4, 2 },
                { 1, 5 },
                { 0, 4 },
                { 3, 1, 5 },
                { 4, 2 }
        };
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        int res = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String top = q.poll();
                visited.add(top);
                if (top.equals(target))
                    return res;
                int idx = top.indexOf('0');
                for (int neigh : neighbor[idx]) {
                    String newBoard = swap(top.toCharArray(), neigh, idx);
                    if (!visited.contains(newBoard))
                        q.offer(newBoard);
                }
            }
            res++;
        }
        return -1;
    }

    String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        // Use new String(char[]) or String.valueOf(char[])
        // Avoid using Arrays.toString(char[]) or char[].toString
        return new String(chars);
    }
}
// @lc code=end
