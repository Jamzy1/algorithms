package linkedList;

public interface List<T> {      //线性表接口
    boolean isEmpty();
    int size();
    T get(int i);
    void set(int i, T x);
    String toString();
    int insert(int i, T x);
    int insert(T x);
    T remove(int i);
    void clear();
    int search(T key);              //查找首次出现的与key相等元素，返回元素序号i
    boolean contains(T key);
    int insertDifferent(T x);
    T remove(T key);                //删除首次出现的与key相等元素，返回被删除元素
    boolean equals(Object obj);
    void addAll(List<T> list);
}