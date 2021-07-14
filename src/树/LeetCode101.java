package 树;


/**
 * 判断是否为对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root){
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q){
        //左右都为空-是对称
        if (p == null && q == null){
            return true;
        }
        //只有一边为空-不是对称
        if (p == null || q == null){
            return false;
        }
        //如果值相等则递归判断
        return p.val == q.val && check(p.left, q.right) && check(p.right,q.left);
    }
}
