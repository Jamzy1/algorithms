package 树.threadedbinarytree;


//遍历线索化二叉树
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

//        创建树
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

//        测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10 号结点的前驱结点是 =" + leftNode); //3
        System.out.println("10 号结点的后继结点是=" + rightNode); //1
        threadedBinaryTree.threadedList();


    }


}

class ThreadedBinaryTree {

    private HeroNode root;

    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    //    遍历线索化二叉树
    public void threadedList() {

        HeroNode node = root;

        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);

            while ( node.getRightType() == 1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }

    //    重载线索化
    public void threadedNodes() {
        threadedNodes(root);
    }

    //    中序线索化
    public void threadedNodes(HeroNode node) {

        if (node == null) {
            return;
        }

//        先线索化左子树
        threadedNodes(node.getLeft());

//        如果node的左子树为空，则线索化连接到pre，然后设置type
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

//        处理右子树
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

//        每处理完一个结点，让当前结点是下一结点的前驱结点
        pre = node;

//        再线索化右子树
        threadedNodes(node.getRight());


    }

}

class HeroNode {

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //    如果 leftType = 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
//    如果 rightType = 0 表示指向的是右子树, 如果 1 表示指向后继结点
    private int leftType;
    private int rightType;

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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
