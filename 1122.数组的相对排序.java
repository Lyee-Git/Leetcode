/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        int n = -arr2.length;
        for (int i = 0; i < arr2.length; i++) {
            mapping.put(arr2[i], n);
            n++;
        }
        // Change from IntStream to Stream<Integer> : boxed()
        // Change back to IntStream: mapToInt(Integer::valueOf)
        return Arrays.stream(arr1).boxed().sorted((Integer a, Integer b) -> {
            if (mapping.containsKey(a)) {
                a = mapping.get(a);
            } 
            if (mapping.containsKey(b))
                b = mapping.get(b);
            return a - b;
        }).mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

