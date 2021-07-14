package 树;



//二叉树递归遍历

/**
 * 访问各个结点的顺序一样的，每个结点都会被访问三次，前中后三次遍历就是打印第几次访问
 */
public class binaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "kkk");

//        手动创建二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        binaryTree.setRoot(root);

//        测试遍历
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();

//        测试查找
        System.out.println("前序查找");
//        System.out.println(binaryTree.postOrderSearch(5));
        binaryTree.delNode(5);
        binaryTree.preOrder();

    }
}


class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //    前序遍历
    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    中序遍历
    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    后序遍历
    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //    前序查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        }
        return null;
    }

    //    中序查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        }
        return null;
    }

    //    后序查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        }
        return null;
    }

    //    删除结点
    public void delNode(int no) {
        if (root!=null){

            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }

        }else {
            System.out.println("空树，无法删除");
        }
    }
}

class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //    前序遍历
    public void preOrder() {

        System.out.println(this);   //先输出根节点

        if (this.left != null) {   //左遍历
            this.left.preOrder();
        }
        if (this.right != null) {  //右遍历
            this.right.preOrder();
        }

    }

    //    中序遍历
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //    后序遍历
    public void postOrder() {

        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);


    }

    //    前序查找
    public HeroNode preOrderSearch(int no) {

        System.out.println("进入前序查找");

        if (this.no == no) {    //先比较根节点
            return this;
        }

        HeroNode resNode = null;

        if (this.left != null) {    //左遍历
            resNode = this.left.preOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {   //右遍历
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    //    中序查找
    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;

        if (this.left != null) {    //先左遍历
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");

        if (this.no == no) {    //再比较根节点
            return this;
        }
        if (this.right != null) {   //再右遍历
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    //    后序查找
    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;

        if (this.left != null) {    //先左遍历
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {   //再右遍历
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {   //最后比较根节点
            return this;
        }
        return null;    //左右中都没找到，直接返回null
    }

    //    删除结点，如果是叶子节点直接删除，是非叶子节点则删除该子树
    public void delNode(int no) {

        if (this.left != null && this.left.no == no) {     //判断左结点
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {   //判断右结点
            this.right = null;
            return;
        }
        if (this.left != null) {                       //左递归
            this.left.delNode(no);
        }
        if (this.right != null) {                      //右递归
            this.right.delNode(no);
        }
    }
}
