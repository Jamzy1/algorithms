package tree;


//顺序二叉树:数组实现树
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,7,8};
        ArrBinaryTree arrBinaryTree=new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();

    }

}

//顺序存储二叉树遍历
class ArrBinaryTree{

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

//    重载方法
    public void preOrder(){
        preOrder(0);
    }

    public void preOrder(int index){

        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }

        System.out.print(arr[index]); //根结点

        if ((index*2+1)<arr.length){    //左遍历
            preOrder(index*2+1);
        }
        if ((index*2+2)<arr.length){    //右遍历
            preOrder(index*2+2);
        }
    }
}
