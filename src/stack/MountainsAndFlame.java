package stack;


import java.util.Stack;

/**
 * 单调栈===山峰对
 * <p>
 * 给一个数组组成的环形山峰，返回能相互看见的山峰对数
 * 相邻的默认可以看见、中间小于两边的也可以看见
 * <p>
 * 思路：
 * 一：如果数组没有相同的，则res=(n-2)*2+1---在环上取最高和次高，中间的点的两边都有看得见的(n-2)*2,加上最高和次高这一对
 * <p>
 * 二：如果有相同的，取最大的数(如果最大的有相同，取最前面的)入栈，栈顶到栈底从小到大，栈统计元素和出现的个数
 * 然后遍历数组遇到小的直接入栈，遇到大的则将小的出栈，同时统计出栈元素的山峰对
 */
public class MountainsAndFlame {

    //    栈中存放的结构，有值和次数
    public static class pair {
        public int value;
        public int times;

        public pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }


    public static long communication(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
//        找出数组的最大值的下标
        int maxIndex = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }

        int value = arr[maxIndex];    //最大值
        int index = nextIndex(size, maxIndex);     //最大值的下一个，因为是环形，所有要处理下
        long res = 0L;
        Stack<pair> stack = new Stack<>();
        stack.push(new pair(value));    //先将最大数入栈
//        遍历环形数组
        while (index != maxIndex) {
            value = arr[index];
//            当放入的数大于栈顶时，出栈,并统计出栈元素的山峰对--C选2 加 2*n
            while (!stack.isEmpty() && stack.peek().value < value) {
                int times = stack.pop().times;
                res += getInternalSum(times) + 2 * times;
            }
//            如果和栈顶元素相等，直接times++
            if (stack.peek().value == value) {
                stack.peek().times++;
//                否则新建一个加入（不大也不等，就是小于的时候）
            } else {
                stack.push(new pair(value));
            }
//            index向后走
            index = nextIndex(size, index);
        }
//        当遍历完，栈还没空时
        while (!stack.isEmpty()) {
//            每弹出一个，这一个内部必产生C选2
            int times = stack.pop().times;
//            先算必有的内部产生的
            res += getInternalSum(times);
//            如果底下还有，则至少还有一个times
            if (!stack.isEmpty()) {
                res += times;
//                如果底下有两个，则是2*times
                if (stack.size() > 1) {
                    res += times;
//                    如果底下有只有一个但是出现了两次，则也是2*times，否则就只有上面那个times
                } else {
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;

    }

    //    返回下一个下标
    public static int nextIndex(int size, int i) {
        return i < (size - 1) ? i + 1 : 0;
    }

    //    C选2的小方法
    public static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

}
