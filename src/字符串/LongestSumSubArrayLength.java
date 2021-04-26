package 字符串;

import java.util.HashMap;


/**
 * 最长累加和
 *
 * 在一个数组中找出一个最长的子串，使其和为k
 *
 * 思路：遍历整个串，遍历的过程累加，
 * 并且将累加的和（sum）以及累加的当前位置下标存入map
 *
 * 判断 当前的sum 减掉 k 是否在map中存在，存在就说明数组中间有一段子串和为k，记录长度
 *
 * 随后求最大长度
 */
public class LongestSumSubArrayLength {

    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        刚开始从-1位置开始，不然会漏掉0位置
        map.put(0, -1); // important
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
//            如果map有
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
//            如果map中没有这个sum才加入，有的话说明map中已经有位置在更前的sum了，更前的sum得到的子串越长
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

//    产生随机数组
    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        printArray(arr);
        System.out.println(maxLength(arr, 10));

    }
}
