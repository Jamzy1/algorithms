package tree;

import java.util.LinkedList;
import java.util.List;

public class test {

    public int[] levelOrder(TreeNode root) {
        int len = countNode(root);
        int[] nodes = new int[len];
        if(len == 0) return nodes;
        LinkedList<TreeNode> list = new LinkedList<>();
        int index = 0;
        list.addLast(root);
        while(list.size() != 0){
            for(int i = 0; i<list.size(); i++){
                TreeNode temp = list.getFirst();
                list.removeFirst();
                nodes[index++] = temp.val;
                if(temp.left != null) list.addLast(temp.left);
                if(temp.right != null) list.addLast(temp.right);
            }
        }
        return nodes;

    }
    int countNode(TreeNode root){
        if(root==null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
