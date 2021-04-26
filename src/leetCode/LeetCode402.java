package leetCode;


import java.util.LinkedList;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 个数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * <p>
 * 思路：遍历数组，要是遍历到的数组元素＜上一个数组元素，则删除上一个数组元素，继续跟上上一个比较
 */
public class LeetCode402 {

    public static void main(String[] args) {
        String num="1432219";
        int k=3;
        LeetCode402 leetCode402 = new LeetCode402();
        System.out.println(leetCode402.removeKdigits(num, k));

    }

    public String removeKdigits(String num, int k) {

        LinkedList<Character> list = new LinkedList<Character>();
        int len = num.length();
//        循环数组，第一个加入队列，之后小于队列最后一个的则删掉队列最后一个，大于的直接加入队列
        for (int i = 0; i < len; i++) {

            char digit = num.charAt(i);
            if (!list.isEmpty() && k > 0 && list.peekLast() > digit) {
                list.pollLast();
                k--;
            }
            list.offerLast(digit);

        }

//        删掉队尾k个数字(k是前面减完的)
        for (int i = 0; i < k; i++) {
            list.pollLast();

        }

        StringBuffer res = new StringBuffer();
        boolean flag = true;
        while (!list.isEmpty()) {
            char digit = list.pollFirst();
            if (flag && digit == '0') {
                continue;
            }
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();


    }
}
