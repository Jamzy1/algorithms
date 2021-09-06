package 分治_二分;

import java.util.Arrays;

public class QuickSort {

	//    快排，空间换时间，冒泡的改进，每次确定中间所有相同的数（改进快排）
	//    经典快排是小于等于放左边，大于放右边，然后递归
	public static void main(String[] args) {

		int[] arr = {-9, 780, 23, -567, 0, -1, 90, 4561};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	//    快速排序，递归实现
	public static void quickSort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;

//        分别从两个端点向中间遍历，当相遇时退出循环
		while (l < r) {

//            找左边大于等于中间点的数
			while (arr[l] < pivot) {
				l += 1;
			}

//            找右边小于等于中间点的数
			while (arr[r] > pivot) {
				r -= 1;
			}

//            找不到直接退出
			if (l >= r) {
				break;
			}

//            找到进行交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

//            如果找到等于中间点，前移一位
			if (arr[l] == pivot) {
				r -= 1;
			}

			if (arr[r] == pivot) {
				l += 1;
			}
		}
		if (l == r) {
			l += 1;
			r -= 1;
		}
		if (left < r) {
			quickSort(arr, left, r);
		}

		if (l < right) {
			quickSort(arr, l, right);
		}

	}
}
