
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */
import java.util.*;

// @lc code=start
class Solution {
    Random random = new Random();

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<int[]> pairs = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pairs.add(new int[] { entry.getKey(), entry.getValue() });
        }
        int[] res = new int[k];
        quickSort(pairs, 0, pairs.size() - 1, k, res, 0);
        return res;
    }

    private void quickSort(List<int[]> pairs, int start, int end, int k, int[] res, int resIdx) {
        int randomIdx = random.nextInt(end - start + 1) + start;
        Collections.swap(pairs, start, randomIdx);
        int pivot = pairs.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (pairs.get(i)[1] >= pivot) {
                Collections.swap(pairs, i, index + 1);
                index++;
            }
        }
        int n = index - start + 1;
        if (n > k) {
            // Only get Top n elements, need further partition
            Collections.swap(pairs, index, start); // swap to set pairs[index] pivot
            quickSort(pairs, start, index - 1, k, res, resIdx);
        } else {
            for (int i = start; i <= index; i++) {
                res[resIdx++] = pairs.get(i)[0];
            }
            if (n < k) {
                quickSort(pairs, index + 1, end, k - n, res, resIdx);
            }
        }
    }

    // public static void main(String[] args) {
    // int[] nums = new int[] {1,1,1,2,2,3333};
    // Main main = new Main();
    // main.topKFrequent(nums, 2);
    // }
}
// @lc code=end
