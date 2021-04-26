package 并查集_前缀数;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集的实现
 * 1、判断两个node是否属于同一个set                 查
 * 2、将两个node分别所在的set合并成一个大set         并
 */
public class UnionFind {

    public static class Node {
        // whatever you like
    }

    public static class UnionFindSet {

        //        key:childNode         value:fatherNode
        public HashMap<Node, Node> fatherMap;

        //        key:node              value:所在集合的size
        public HashMap<Node, Integer> sizeMap;


        //        初始化
        public UnionFindSet() {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        //        只接受一次性把所有的node都给出来
        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();

//            所有node都单独为一个set（父节点都是自己，next指针指向自己，每个的size都为1）
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

//        找到结点的头、并将 该节点到头之间所有的结点都直接指向父
        private Node findHead(Node node) {

            Node father = fatherMap.get(node);
//            递归找到father
            if (father != node) {
                father = findHead(father);
            }
//            将链上所有node指向father
            fatherMap.put(node, father);
            return father;
        }

//        判断是否是同一个头,是同一个头就说明是同一个set
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

//        将两个set合并
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
//            找出两个头
            Node aHead = findHead(a);
            Node bHead = findHead(b);
//            如果不相等
            if (aHead != bHead) {
//                找出两个set的大小
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
//                    把小的的头指向大的的头
                    fatherMap.put(aHead, bHead);
//                    更新大set的size
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
