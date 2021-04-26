package tree;


/**
 * 找到一棵树上两个结点的最近公共祖先结点
 * (一个结点的祖先结点可以是它本身)
 * <p>
 * 思路：通过对二叉树进行后序遍历，如果遇到p、q时返回。从底至顶回溯，当p、q、在结点root的异侧时，返回root
 */
public class LeetCodeOffer68_2 {

    //    结点类
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
                                                TreeNode q) {
//        如果root==p或q，直接返回，root为最近祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        如果左边没有，说明两结点都在右边，返回right
//        因为是从底向上，所以返回的都是从近到远
        if (left==null) return right;

        if (right==null) return left;
        return root;
    }
}
