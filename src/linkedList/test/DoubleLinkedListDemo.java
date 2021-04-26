package linkedList.test;

import linkedList.guigu.DoubleLinkedList;
import linkedList.guigu.HeroNode2;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
//        doubleLinkedList.addByOrder(hero4);

//        展示
        doubleLinkedList.list();

//        修改
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(newHeroNode);
        System.out.println("======");


//        删除
//        doubleLinkedList.del(3);
//        doubleLinkedList.list();

    }

}
