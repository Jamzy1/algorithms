package hashTab;

import java.util.HashMap;

/**
 *
 * 布隆过滤器、一致性哈希
 *
 * 设计一个结构：不重复插入key、删除key、随机返回一个key
 *
 * 用两个hashMap实现
 */
public class RandomPool {

    public static class Pool<K> {

//        第一个放key和放入顺序
        private HashMap<K, Integer> keyIndexMap;

//        第二个放顺序和key
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
//            存个index才能完成随机取
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        public void insert(K key) {
//            确定没有才插入
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

//        删除一个key之后将末尾key补上来，然后size--，保证结构不破洞，才能完成随机取操作
        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {

//                取删除数的下标
                int deleteIndex = this.keyIndexMap.get(key);
//                最后数的下标
                int lastIndex = --this.size;
//                最后数的key
                K lastKey = this.indexKeyMap.get(lastIndex);
//                直接将删除数替换成最后最后数
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
//                删除最后数
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

//        取0~size中一个随机数，然后返回
        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return this.indexKeyMap.get(randomIndex);
        }

    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }
}
