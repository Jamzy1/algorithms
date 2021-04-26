package linkedList.guigu;


//结点类，每个对象就是一个结点
public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个结点

    //    构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
