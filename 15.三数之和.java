
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length, target = 0;
        for (int i = 0; i < n; i++) {
            int third = nums[i];
            List<List<Integer>> twoCombins = twoSum(nums, i + 1, target - third);
            for (List<Integer> twoCombin : twoCombins) {
                twoCombin.add(third);
                res.add(twoCombin);
                // 第一个数字也不能重复
                while (i < n - 1 && nums[i + 1] == third)
                    i++;
            }
        }
        return res;
    }

    List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int end = nums.length - 1;
        List<List<Integer>> res = new LinkedList<>();
        while (start < end) {
            int left = nums[start], right = nums[end];
            int sum = nums[start] + nums[end];
            if (sum < target) {
                while (start < end && nums[start] == left)
                    start++;
            } else if (sum > target) {
                while (end > start && nums[end] == right)
                    end--;
            } else {
                // 外层的 {} 定义了一个 LinkedList 的匿名内部类。内层的 {} 的定义了一个实例初始化代码块。
                // 这个代码块在初始化内部类时执行。所以这里相当于定义了一个匿名内部类，并使用 add 添加元素来初始化
                // {{add(start);add(end);}}
                res.add(new LinkedList<>(Arrays.asList(nums[start], nums[end])));
                while (start < end && nums[start] == left)
                    start++;
                while (end > start && nums[end] == right)
                    end--;
            }
        }
        return res;
    }

    // public static void main(String[] args) {
    // Main main = new Main();
    // int[] nums = new int[]{1,2,-2,-1};
    // main.threeSum(nums);
    // }
}

// @lc code=end
