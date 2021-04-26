package linkedList.test;

import linkedList.guigu.HeroNode;
import linkedList.guigu.SingleLinkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

//        创建结点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero5 = new HeroNode(5, "林冲", "豹子头");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

//        创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();

//        不按顺序加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero2);

//        按编号加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero8);
        singleLinkedList1.addByOrder(hero7);
        singleLinkedList1.addByOrder(hero3);
        singleLinkedList1.addByOrder(hero6);
        singleLinkedList1.addByOrder(hero4);


//        修改
//        HeroNode kkk = new HeroNode(2,"ppp","eee");
//        singleLinkedList.update(kkk);

//        singleLinkedList.list();

        singleLinkedList1.reverseList(hero3);
        singleLinkedList1.list();
        System.out.println("=======");

//        删除
//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.del(3);
//        singleLinkedList.del(4);

//        输出

//        singleLinkedList.list();


    }
}
