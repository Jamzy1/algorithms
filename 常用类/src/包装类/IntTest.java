package 包装类;

public class IntTest {

    public static void main(String[] args) {
        int m = 500;
        Integer obj = m;
        int n = obj;
        System.out.println("n = "+n);
        Integer obj1 = 500;
        System.out.println("obj等价于"+obj.equals(obj1));//会自动装箱和拆箱
        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());
    }
}
