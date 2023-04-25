import java.util.*;

class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(track, candidates, 0, 0, target);
        return res;
    }

    public void backtrack(LinkedList<Integer> track, int[] nums, int start, int trackSum, int target) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (trackSum + nums[i] > target)
                break;
            trackSum += nums[i];
            track.add(nums[i]);
            backtrack(track, nums, i, trackSum, target);
            trackSum -= nums[i];
            track.removeLast();
        }
    }
}