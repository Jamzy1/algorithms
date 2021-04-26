package 递归_动规;

import java.util.HashMap;

/**
 * 将一个数组划分、使得划分的 异或和为0的 子数组个数最多
 */

public class Most_EOR {

    public static int mostEOR(int[] arr) {
        if (arr==null||arr.length==0){
            return 0;
        }

        int eor = 0;

//        dp[i]表示0~i的数组能分割的最多个数
        int[] dp = new int[arr.length];
//        用于快速判断前面是否有出现过的数  key:前面所有数异或和  value:下标
        HashMap<Integer, Integer> map = new HashMap<>();
//        初始值
        dp[0] = arr[0] == 0 ? 1 : 0;
        map.put(0, -1);
        map.put(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)) {
                int preEorIndex = map.get(eor);
                dp[i] = preEorIndex == -1 ? 1 : (dp[preEorIndex] + 1);
            }
            dp[i]=Math.max(dp[i],dp[i-1]);
            map.put(eor,i);
        }
        return dp[dp.length-1];
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] eors = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            eors[i] = eor;
        }
        int[] mosts = new int[arr.length];
        mosts[0] = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            mosts[i] = eors[i] == 0 ? 1 : 0;
            for (int j = 0; j < i; j++) {
                if ((eors[i] ^ eors[j]) == 0) {
                    mosts[i] = Math.max(mosts[i], mosts[j] + 1);
                }
            }
            mosts[i] = Math.max(mosts[i], mosts[i - 1]);
        }
        return mosts[mosts.length - 1];
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 300;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = mostEOR(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
