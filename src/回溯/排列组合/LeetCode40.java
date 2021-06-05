package 回溯.排列组合;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 在数组中找出能相加为target的序列,每个数只能用一次,解集中不能包含重复的组合
 * 和排列的第二题一样,要把解集中重复的去掉
 * 剪枝过程中要把同一层中重复的去掉
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        bfs(0,target,candidates,res,new ArrayDeque<Integer>());
        return res;
    }

    private void bfs(int begin, int target, int[] nums, List<List<Integer>> res, Deque<Integer> path) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (target - nums[i] < 0) break;
            //如果这一层的数在这一层的另一种情况已经出现过，则直接忽略
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            //每一次递归就相当于进入了下一层
            //每种情况会一直递归下去，然后再回溯回来，回溯回来后循环会带着他去再次递归(换成其他数了)
            //因为数不能重复用，所以begin只能是i+1
            bfs(i+1,target-nums[i],nums,res,path);
            path.removeLast();
        }
    }
}
