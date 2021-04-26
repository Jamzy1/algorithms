package leetCode;


import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * <p>
 * <p>
 * 思路:从题意可以构建图，起点和终点已知。用BFS遍历该图，找到最短路径
 * 每个单词为图的每个结点，由于很多单词之间都只相差一个字母，所以很多结点之间都有路径，因此是无向图。
 * 所以需要标记遍历过的结点，不然走出来的不是最短路径
 */
public class LeetCode127 {

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList =new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        LeetCode127 leetCode127 = new LeetCode127();
        System.out.println(leetCode127.ladderLength(beginWord, endWord, wordList));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

//        将wordList放到哈希表中，便于判断某个单词是否在列表中
        Set<String> hashSet = new HashSet<String>(wordList);

        if (!hashSet.contains(endWord)) {
            return 0;
        }
        hashSet.remove(beginWord);

//        图的广度优先遍历，用到队列和一个判断是否遍历过的哈希表visited
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {

            int currentSize = queue.size();
//            遍历队列中的元素、判断是否改变一个元素就能和endword匹配上
            for (int i = 0; i < currentSize; i++) {

                String currentWord = queue.poll();
                if (changeWord(currentWord, endWord, queue, visited, hashSet)) {
                    return step + 1;
                }
            }

            step++;
        }

        return 0;


    }

    /**
     * 对currentWord修改一个字符，判断能不能与endWord匹配上
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return
     */
    private boolean changeWord(String currentWord, String endWord,
                               Queue<String> queue, Set<String> visited, Set<String> wordSet) {

        char[] charArray = currentWord.toCharArray();

        for (int i = 0; i < endWord.length(); i++) {

//            先把charArray[i]存起来，方便最后还原
            char originChar = charArray[i];

            for (char k = 'a'; k <= 'z'; k++) {

//                如果是单词本身，直接进入下次循环
                if (k == originChar) {
                    continue;
                }

                charArray[i] = k;
                String nextWord = String.valueOf(charArray);  //转换为字符串

                if (wordSet.contains(nextWord)) {

//                    如果是最后一个，直接返回
                    if (nextWord.equals(endWord)) {
                        return true;
                    }

//                    如果没被遍历过，则加入队列并标记已遍历，下次从该结点出发
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);//同时标记为已遍历过的

                    }
                }

            }
//            把charArray[i]还原回来
            charArray[i] = originChar;
        }
        return false;


    }
}
