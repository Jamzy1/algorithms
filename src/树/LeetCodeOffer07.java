package 树;


import java.util.*;

/**
 * 重建二叉树，给出前序和中序遍历，返回二叉树
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 思路:确定根节点,再确定左右子树,然后遍历...
 */
public class LeetCodeOffer07 {

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eh = new TreeNode(8);
        root.left = two;
        root.right = three;
        two.left = four;
        four.left = seven;
        three.left = five;
        three.right = six;
        five.left = eh;
        bfs(root);

    }


    public TreeNode buildTree(int[] preOrder, int[] inOrder) {

        if (preOrder == null || preOrder.length == 0) {
            return null;
        }

//        存储中序遍历的结点和下标，方便快速查找
        Map<Integer, Integer> indexMap = new HashMap<>();
        int len = inOrder.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(inOrder[i], i);
        }
        TreeNode root = buildTree(preOrder, 0, len - 1, inOrder, 0, len - 1, indexMap);
        return root;

    }

    //    方法重载，用于递归
    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
//        拿到当前子树的根节点的值，即前序遍历的第一个
        int rootVal = preorder[preorderStart];
//        创建改结点
        TreeNode root = new TreeNode(rootVal);
//        如果该子树没有左右结点，直接返回root
        if (preorderStart == preorderEnd) {
            return root;
//            否则继续遍历
        } else {
//            根节点在中序遍历中的位置
            int rootIndex = indexMap.get(rootVal);
//            左子树的大小
            int leftNodes = rootIndex - inorderStart;
//            右子树的大小
            int rightNodes = inorderEnd - rootIndex;
//            遍历左子树
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
//            遍历右子树
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
//            接上结点
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;

        }

    }

    static Deque<TreeNode> treeNodes = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();

    static List<List<Integer>> bfs(TreeNode root) {


        List<Integer> level = new ArrayList<>();
        if (root!=null){
            level.add(root.val);
        }
        if (root.left != null) {
            treeNodes.add(root.left);
        }
        if (root.right != null) {
            treeNodes.add(root.right);
        }
        if (!treeNodes.isEmpty()) {
            bfs(treeNodes.pop());
        }

        return res;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

