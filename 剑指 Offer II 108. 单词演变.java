
// 剑指 Offer II 108. 单词演变
// @lc code=start
// beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
import java.util.*;

class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    HashMap<String, Integer> wordIndex = new HashMap<>();
    int wordId = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        addEdge(beginWord);
        for (String word : wordList) {
            addEdge(word);
        }
        if (!wordIndex.containsKey(endWord)) {
            return 0;
        }
        int beginIndex = wordIndex.get(beginWord),   endIndex = wordIndex.get(endWord);
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.offer(beginIndex);
        Queue<Integer> q2 = new ArrayDeque<>();
        q2.offer(endIndex);
        int[] dist1 = new int[wordId];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[beginIndex] = 0;
        int[] dist2 = new int[wordId];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[endIndex] = 0;
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                swapQueues(q1, q2, dist1, dist2);
            }
            int sz = q1.size();
            for (int i = 0; i < sz; i++) {
                int cur = q1.poll();
                if (dist2[cur] != Integer.MAX_VALUE) {
                    return step / 2 + 1;
                }
                for (int neigh : edges.get(cur)) {
                    if (dist1[neigh] == Integer.MAX_VALUE) {
                        dist1[neigh] = dist1[cur] + 1;
                        q1.offer(neigh);
                    }
                }
            }
            step++;
            int sz2 = q2.size();
            for (int i = 0; i < sz2; i++) {
                int cur = q2.poll();
                if (dist1[cur] != Integer.MAX_VALUE) {
                    return step / 2 + 1;
                }
                for (int neigh : edges.get(cur)) {
                    if (dist2[neigh] == Integer.MAX_VALUE) {
                        dist2[neigh] = dist2[cur] + 1;
                        q2.offer(neigh);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public void addEdge(String word) {
        char[] wordChars = word.toCharArray();
        int n = wordChars.length;
        if (!wordIndex.containsKey(word)) {
            wordIndex.put(word, wordId++);
            edges.add(new ArrayList<>());
        }
        int indexFrom = wordIndex.get(word);
        for (int i = 0; i < n; i++) {
            char temp = wordChars[i];
            wordChars[i] = '*';
            String interWord = new String(wordChars);
            if (!wordIndex.containsKey(interWord)) {
                wordIndex.put(interWord, wordId++);
                edges.add(new ArrayList<>());
            }
            int indexTo = wordIndex.get(interWord);
            edges.get(indexFrom).add(indexTo);
            edges.get(indexTo).add(indexFrom);
            wordChars[i] = temp;
        }
    }

    public void swapQueues(Queue<Integer> q1, Queue<Integer> q2, int[] dist1, int[] dist2) {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        int[] tempDist = dist1;
        dist1 = dist2;
        dist2 = tempDist;
    }
}
// @lc code=end
