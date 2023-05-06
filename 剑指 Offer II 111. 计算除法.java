
// 剑指 Offer II 111. 计算除法
// @lc code=start
// equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
// [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// ans : [6.00000,0.50000,-1.00000,1.00000,-1.00000]
// 0.0 < values[i] <= 20.0
import java.util.*;

class Solution {
    class Pair {
        int index;
        double value;

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> variableIndex = new HashMap<>();
        List<List<Pair>> edges = new ArrayList<>();
        int nEquat = equations.size();
        int nVariable = 0;
        for (int i = 0; i < nEquat; i++) {
            List<String> equation = equations.get(i);
            if (!variableIndex.containsKey(equation.get(0))) {
                variableIndex.put(equation.get(0), nVariable++);
                edges.add(new ArrayList<>());
            }
            int indexFrom = variableIndex.get(equation.get(0));
            if (!variableIndex.containsKey(equation.get(1))) {
                variableIndex.put(equation.get(1), nVariable++);
                edges.add(new ArrayList<>());
            }
            int indexTo = variableIndex.get(equation.get(1));
            edges.get(indexFrom).add(new Pair(indexTo, values[i]));
            edges.get(indexTo).add(new Pair(indexFrom, 1.0 / values[i]));
        }
        int nQuery = queries.size();
        double[] res = new double[nQuery];
        for (int i = 0; i < nQuery; i++) {
            List<String> query = queries.get(i);
            String s1 = query.get(0), s2 = query.get(1);
            if (!variableIndex.containsKey(s1) || !variableIndex.containsKey(s2)) {
                res[i] = -1.0;
                continue;
            }
            int index1 = variableIndex.get(s1), index2 = variableIndex.get(s2);
            if (index1 == index2) {
                res[i] = 1.0;
                continue;
            }
            res[i] = -1.0; // Initial value
            Queue<Integer> queue = new ArrayDeque<>();
            double[] ratios = new double[nVariable];
            Arrays.fill(ratios, -1.0);
            ratios[index1] = 1.0;
            queue.add(index1);
            while (!queue.isEmpty() && ratios[index2] == -1.0) {
                int cur = queue.poll();
                for (Pair pair : edges.get(cur)) {
                    if (ratios[pair.index] == -1.0) {
                        ratios[pair.index] = ratios[cur] * pair.value;
                        if (pair.index == index2) {
                            res[i] = ratios[index2];
                            break;
                        }
                        queue.offer(pair.index);
                    }
                }
            }
        }
        return res;
    }

}
