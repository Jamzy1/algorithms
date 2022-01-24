package 回溯.排列组合;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 在数组中找出能相加为target的序列,每个数都能重复使用
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        sub(0, candidates, target, res, new ArrayList<Integer>());
        return res;
    }

    private void sub(int begin, int[] sum, int target, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < sum.length; i++) {
            tmp.add(sum[i]);
            //这里传入begin的话会把所有的子集的不同顺序都返回，如果是begin它会去匹配begin前面的数
            //会先全选第一个位置的数，累加后不行就把最后一个数换位第二个
            //下面传入i而不是i+1是因为每个数能重复用
            sub(i,sum,target-sum[i],res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
