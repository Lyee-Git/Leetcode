/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */
import java.util.*;
// @lc code=start
class RandomizedSet {
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> valToIndex;
    Random random;
    public RandomizedSet() {
        arr = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (valToIndex.containsKey(val))
            return false;
        valToIndex.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val))
            return false;
        int index = valToIndex.get(val);
        int elem = arr.get(arr.size() - 1);
        arr.set(index, elem);
        arr.remove(arr.size() - 1);
        valToIndex.put(elem, index);
        valToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

