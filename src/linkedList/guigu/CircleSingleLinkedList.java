package linkedList.guigu;


//约瑟夫环

/**
 * 思路一：考的是循环链表的操作，用LinkedList会超时(可以自己写循环链表)，用ArrayList不会，因为ArrayList最后的前移是内存地址整块前移
 * 思路二：数学思路，逆推，因为要求的是最后剩余结点刚开始时的下标，因为每删除一个数，其他数的下标都会改变，
 *       所以从最后开始逆推回去，找到刚开始是幸存数的下标。
 *       https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/huan-ge-jiao-du-ju-li-jie-jue-yue-se-fu-huan-by-as/
 */
public class CircleSingleLinkedList {

    private Boy first = null;       //没有编号

    /**
     * 添加结点并形成环状
     *
     * @param nums 添加节点的个数
     */
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表

        for (int i = 1; i <= nums; i++) {

            Boy boy = new Boy(i);

            if (i == 1) {
                first = boy;
                first.setNext(first);   //形成循环
                curBoy = first;     //让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    //    遍历当前环形链表
    public void showBoy() {

        if (first == null) {
            System.out.println("当前链表为空");
            return;
        }

        Boy curBoy = first;

        while (true) {

            System.out.printf("小孩的编号%d\n", curBoy.getNo());

            if (curBoy.getNext() == first) {    //遍历已结束
                break;
            }

            curBoy = curBoy.getNext();
        }
    }

//    joseph问题

    /**
     * @param startNo  开始计数的小孩
     * @param countNum 数几下
     * @param nums     最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {

//        数据校验
        if (first == null || startNo < 1 || countNum > nums) {
            System.out.println("参数有误，重新输入");
            return;
        }

//        创建一个辅助结点并让其指向最后一个节点
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

//        开始出圈前先让first和helper结点移动到起始出圈位
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

//        报数时，first和helper同时移动并进行删除操作
        while (true){
            
            if (helper==first){     //出圈剩最后一个结点时，遍历结束
                break;
            }

            for (int j = 0; j < countNum-1; j++) {
                helper=helper.getNext();
                first=first.getNext();
            }

            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
            
        }
        System.out.printf("最后留在圈中的小孩的编号%d\n",first.getNo());

    }
}
