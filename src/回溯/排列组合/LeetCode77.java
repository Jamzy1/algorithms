package 回溯.排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 */
public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0 || k > n) return res;
        bfs(1,n,k,res,new ArrayList<Integer>());
        return res;
    }
    private void bfs(int begin,int n, int k, List<List<Integer>> res, List<Integer> tmp){
        if(k == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=begin; i<n+1; i++){
            tmp.add(i);
            //这里的begin要用i+1，每次只能去后面找
            //如果用begin+1会出现[2,4] [4,2]的情况，会回头找
            bfs(i+1, n, k-1,res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
