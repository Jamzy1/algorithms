package 字符串;


/**
 * 在一个数组中求第k小的数(或者说k个最小的数)，时间复杂度O(n)       如果进行排序时间复杂度为O(n*logn)
 *
 * 思路：
 * 1、将数组 5个数为一组进行分组，并将所有组的中位数组成一个数组，求中位数数组的中位数（将该中位数做划分值）
 *
 * 2、将该划分值进行partition，返回一个中间的等于区域（小于放左边，等于放中间，大于放右边）
 *
 * 3、判断第k个数在等于区域的左还是右，如果命中直接返回，否则选择命中的一边继续bfprt
 */
public class BFPRT {



    // 用堆实现   O(N*logK)
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
//        k不在arr范围内
        if (k < 1 || k > arr.length) {
            return arr;
        }
//        将0~k个数排序，堆排序（维护一个大根堆）
        int[] kHeap = new int[k];

//        大根堆的容量是k（最后返回该堆），先将前面的k个数Insert进堆
        for (int i = 0; i != k; i++) {
            heapInsert(kHeap, arr[i], i);
        }

//        然后继续遍历第k个后面的数，如果小于堆顶就 换堆顶-再调整 如果大于就忽略（堆顶是堆中最大的数）
        for (int i = k; i != arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

//    堆插入
    public static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

//    堆调整
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    // O(N)     获得所有比第k小的数还要小的数
    public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
//        获得第k小的数
        int minKth = getMinKthByBFPRT(arr, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }
        for (; index != res.length; index++) {
            res[index] = minKth;
        }
        return res;
    }

//    获得第k小的数
    public static int getMinKthByBFPRT(int[] arr, int K) {
        int[] copyArr = copyArray(arr);
        return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
    }

//    复制一个数组
    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

//    在begin和end范围上求第i小的数(bfprt主体)
    public static int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
//        中位数数组中的中位数作为划分值
        int pivot = medianOfMedians(arr, begin, end);
//        将该划分值进行partition，返回一个中间的等于区域
        int[] pivotRange = partition(arr, begin, end, pivot);
//        判断第k个数在等于区域的左还是右
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
//            命中直接返回
            return arr[i];
        } else if (i < pivotRange[0]) {
//            在左边进行bfprt
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

//    求中位数数组中的中位数
    public static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
//        5个数做一组
        int offset = num % 5 == 0 ? 0 : 1;
//        一共有多少组，最后存放每个数组的中位数
        int[] mArr = new int[num / 5 + offset];
//        把每5个数拿出来(用边界)，分别求中位数然后放入mArr
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
            // min预防最后一个数组不足5个数
        }
//        然后再递归，直到mArr不足5个
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

//    获得中位数
    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

//    对小数组插入排序
    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getMinKNumsByHeap(arr, 15));
        printArray(getMinKNumsByBFPRT(arr, 15));

    }
}
