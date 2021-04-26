package linkedList;/*
线性表的顺序存储和实现。。顺序表即数组
**/

public class SeqList<T> implements List<T> {
    protected Object[] element;                     //element.length是顺序表空间大小
    protected int n;                                //this.n是内容的多少

    public SeqList(int length) {                     //第一个构造方法,定义容量为length
        this.element = new Object[length];
        this.n = 0;                                   //还没给内容所以n=0
    }

    public SeqList() {                               //无参构造方法
        this(64);                                //调用第一个构造方法并传入length=64
    }

    public SeqList(T[] values) {                     //构造方法，传入数组
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.element[i] = values[i];
            this.n = element.length;
        }
    }

    public boolean isEmpty() {                      //判空
        return this.n == 0;
    }

    public int size() {                             //返回大小
        return this.n;
    }

    public T get(int i) {                           //返回序号i的元素
        if (i >= 0 && i < this.n)
            return (T) this.element[i];
        return null;
    }

    public void set(int i, T x) {                   //设置序号i的元素为x
        if (x == null)
            throw new NullPointerException("x==null");
        if (i >= 0 && i < this.n)
            this.element[i] = x;
        else throw new IndexOutOfBoundsException(i + "");
    }



    public String toString() {                      //返回线性表描述的所有字符串
        String str = this.getClass().getName() + "(";
        if (this.n > 0)
            str += this.element[0].toString();
        for (int i = 1; i < this.n; i++)
            str += "," + this.element[i].toString();
        return str + ")";
    }



    public int insert(int i, T x) {                     //插入x在i位置上
        if (x==null)
            throw new NullPointerException("x==null");
        if (i<0)
            i=0;
        if (i>this.n)
            i=this.n;
        Object[] source=this.element;
        if (this.n==element.length){                    //若数组满，则扩容
            this.element=new Object[element.length];
            for(int j=0;j<i;j++)                        //扩容后将i前面的元素搬到新数组
                this.element[j]=source[j];
        }
        for (int j = this.n-1; j >=i; j--)              //将i后面的数组向后移一位
            this.element[j+1]=source[j];
        this.element[i]=x;
        this.n++;
        return i;
    }



    public int insert(T x) {                            //在顺序表最后插入x
        return this.insert(this.n,x);
    }



    public T remove(int i) {
        if (this.n>0 && i>=0 && i<this.n){
            T old=(T) this.element[i];
            for (int j = i; j <this.n-1 ; j++)          //将i后面的元素前移
                this.element[j]=this.element[j+1];
            this.element[this.n-1]=null;                //最后一个数组元素对象设为空
            this.n--;
            return old;
        }
        return null;
    }

    public void clear() {                               //删除内容但空间还在
        this.n=0;
    }



    public int search(T key) {
        for (int i = 0; i <this.n ; i++) {
            if (key.equals(this.element[i]))
                return i;
        }
        return -1;
    }


    public boolean contains(T key) {
        return this.search(key)!=-1;
    }


    public boolean equals(Object obj) {             //比较两个顺序表是否相等
        if (this==obj)
            return true;
        if (obj instanceof SeqList<?>) {
            SeqList<T> list=(SeqList<T>)obj;
            if (this.n==list.n){
                for (int i = 0; i < this.n; i++) {
                    if (!(this.get(i).equals(list.get(i))))
                        return false;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int insertDifferent(T x) {
        return 0;
    }

    @Override
    public T remove(T key) {
        return null;
    }

    @Override
    public void addAll(List<T> list) {

    }
}