package 回溯.排列组合;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 数组的全排列,不包含重复的元素,排列出来的数组都是不同的
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        //  用来表示该数是否用过
        boolean[] used = new boolean[nums.length];
        bfs(res, 0, nums, new ArrayList<>(), used);
        return res;
    }
    void bfs(List<List<Integer>> res, int begin, int[] nums, List<Integer> temp, boolean[] used){
        if(begin == nums.length){
            //如果直接把temp加进来，后续再操作temp会把res里面的也全给操作了
            //因为temp指向的是同一个地址
            res.add(new ArrayList<>(temp));
            return;
        }
        //每次进入递归都得从0开始for循环，因为有可能1没用过而2用过了
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                temp.add(nums[i]);
                //该数用过则置为ture
                used[i]=true;
                bfs(res, begin+1, nums, temp, used);
                //该数后面的全排解决后，重置这一层的状态.
                //下面这两步很重要，把3置为没用过之后，3循环结束，进入2，把2置为没用过之后，2的循环还未结束，i+1继续循环，此时发现3没用过，于是把3加入temp=1 3
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
