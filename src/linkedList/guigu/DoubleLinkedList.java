package linkedList.guigu;

public class DoubleLinkedList {

    //    初始化一个头结点
    private HeroNode2 head = new HeroNode2(0, "", "");

    //   返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //    遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //    添加结点到链表最后
    public void add(HeroNode2 heroNode) {

//        辅助结点
        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //    2、根据排名按照顺序添加结点
    public void addByOrder(HeroNode2 heroNode) {

//        创建辅助结点temp，添加的结点就在temp的后一个结点
        HeroNode2 temp = head;
        boolean flag = false;   //判断添加的编号是否已经存在，默认为false
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
            if (temp.next!=null){
                temp.next.pre = heroNode;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }

    }

    //    修改结点
    public void update(HeroNode2 newHeroNode) {

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
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

    //    删除结点
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;

            if (temp.next != null) {    //如果不是最后一个节点，才有必要
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d结点不存在\n", no);
        }
    }


}
