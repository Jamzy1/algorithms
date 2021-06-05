package 单例模式;

/**
 * 双重校验
 */
public class Singleton {

    private volatile static Singleton singleton;


    private void singleton(){

    };

    public Singleton getSingleton(){

        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
