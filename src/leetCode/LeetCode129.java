package leetCode;


/**
 * 计算从根到叶子节点生成的所有数字之和
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * 思路：dfs，递归完相同父节点的两条之后相加赋给该父节点
 *
 */

public class LeetCode129 {

    public int sumNumbers(TreeNode root) {

        return dfs(root,0);

    }

//    深度优先搜索
    public int dfs(TreeNode root,int preSum){

        if(root==null){
            return 0;
        }

//        每一个结点都是下一个结点的十位数
        int sum = preSum*10+root.val;

        if(root.left==null&&root.right==null){
            return sum;
        }else{
            return dfs(root.left,sum)+dfs(root.right,sum);      //左右相加
        }
    }




    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(1);

        root.left=treeNode2;
        root.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
//
        LeetCode129 leetCode129 = new LeetCode129();
        System.out.println(leetCode129.sumNumbers(root));
//
//    }
//
//    public List<Integer> preorderTraversal(TreeNode root){
//        List<Integer> res = new ArrayList<>();
//        dfs(root,res);
//        return res;
//    }
//    public void dfs(TreeNode root,List<Integer> res){
//        if (root==null){
//            return ;
//        }
//        res.add(root.val);
//        dfs(root.left,res);			//先左边一直走下去，走到尽头就回退一个走右边
//        System.out.println(res);
//        dfs(root.right,res);
//    }
    }


}
class TreeNode {  //从上到下搜索并输出，根、左、右(递归实现先序遍历树)
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


