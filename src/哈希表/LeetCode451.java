package 哈希表;


import java.util.*;

/**
 * 根据字符串出现的频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class LeetCode451 {

    public String frequencySort(String s) {

        //map中key为字符串的字符，value为字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //如果有c则拿他的value，如果没有默认是0
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        //将map中的key取出排序，按照出现次数进行排
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        //根据出现次数和排好的序列构造答案
        StringBuffer buffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Character c = list.get(i);
            for (int j = 0; j < map.get(c); j++) {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
