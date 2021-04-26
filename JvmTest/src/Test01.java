import java.util.ArrayList;


//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
//-Xms  设置初始化内存分配大小 1/64
//-Xmx  设置最大内存分配      1/4
//-XX:+printGCDetails   打印GC垃圾回收信息
//-XX:+HeapDumpOnOutOfMemoryError   oom Dump
public class Test01 {

    public static void main(String[] args) {
        ArrayList<Test01> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new Test01());
                count=count+1;
            }

        }catch (Error e){
            System.out.println("count"+count);
            e.printStackTrace();
        }

    }
}
