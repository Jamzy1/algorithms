package linkedList.guigu;

import java.util.Stack;

public class SingleLinkedList {


    //初始化头结点，头结点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0, " ", " ");

    //    返回头结点
    public HeroNode getHead() {
        return head;
    }

    //    1、添加结点到链表，不考虑顺序，找到该链表的最后节点然后将这个结点的next指向新的结点
    public void add(HeroNode heroNode) {
//        因为head结点不能动，因此需要一个辅助遍历temp
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
//        退出while循环时temp就指向了链表的最后
        temp.next = heroNode;
    }


    //    2、根据排名按照顺序添加结点
    public void addByOrder(HeroNode heroNode) {

//        创建辅助结点temp，添加的结点就在temp的后一个结点
        HeroNode temp = head;
        boolean flag = false;//判断添加的编号是否已经存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经到链表的最后，直接跳出循环
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {//编号已存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，继续遍历
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", heroNode.no);
        } else {
//            插入到链表中，temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    //    修改链表
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;//判断是否找到要修改的结点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的结点，不能修改\n", newHeroNode.no);
        }
    }


    //    删除结点  (删除结点要注意要让被删除结点的上一个结点指向被删除节点的下一个指针)
//    双指针法、或者建立一个辅助结点temp，每次都是判断temp.next
//    走向下一个：temp=temp.next......删除：temp.next=temp.next.next;
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }


    //    显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //    获取链表有效节点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //    查找倒数第k个结点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {

        if (head.next == null) {   //判空
            return null;
        }
        int size = getLength(head);   //得到长度

        if (index <= 0 || index > size) {  //检测index
            return null;
        }

        HeroNode cur = head.next;       //临时变量

        for (int i = 0; i < size - index; i++) {  //循环查找
            cur = cur.next;
        }
        return cur;
    }

    //    反转单链表
    public static void reverseList(HeroNode head) {


        if (head.next == null || head.next.next == null) {      //判断是否为空或者只有一个结点
            return;
        }

        HeroNode cur = head.next;   //辅助遍历
        HeroNode next = null;       //暂存结点
        HeroNode reverseHead = new HeroNode(0, " ", "");    //新节点头部

        while (cur != null) {
            next = cur.next;    //暂存在next
            cur.next = reverseHead.next;    //先接上cur后面的线,cur遍历旧链表,将cur插到reverseHead和上一个cur中间
            reverseHead.next = cur;         //在接上cur前面的线
            cur = next;           //cur后移
        }
        head.next = reverseHead.next;         //将head接上
    }

    //    逆序打印单链表(用栈实现)
//    先反转再打印会改变链表原来的结构
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
