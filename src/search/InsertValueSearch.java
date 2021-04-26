package search;

public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr={-1,3,7,53,523,56,998,6666};
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 53));

    }

//    基于二分法的改进,用查找值确定mid，减少递归次数
    public static int insertValueSearch(int[] arr,int left,int right,int findValue){

        if (left>right||findValue<arr[left]||findValue>arr[right-1]){
            return -1;
        }

//        根据查找值求mid，自适应
        int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);


        int midValue=arr[mid];


        if (findValue<midValue){
            return insertValueSearch(arr,left,mid-1,findValue);
        }else if (findValue>midValue){
            return insertValueSearch(arr,mid+1,right,findValue);
        }else {
            return mid;
        }

    }
}
