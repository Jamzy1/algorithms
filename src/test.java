import java.util.HashMap;
import java.util.Set;

//数组中次数最多的元素和个数
public class test {

    public static int[] findNum(int[] nums){
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        //次数
        for(int num : map.values()){
            ans[1] = Math.max(ans[1], num);
        }
        for (int num : map.keySet()){
            if (map.get(num) == ans[1]){
                ans[0] = num;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        int[] ans = findNum(nums);
        System.out.println(ans[0]+ "  "+ans[1]);
    }

}
