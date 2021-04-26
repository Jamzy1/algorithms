package leetCode;


/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 思路：构建一个字符数组，遍历字符串并进行判断，将判断结果输入到数组中，最后将数组转为字符串输出
 */
public class LeetCodeOffer05 {

    public static void main(String[] args) {
        String s = "We are happy.";
        LeetCodeOffer05 leetCodeOffer05 = new LeetCodeOffer05();
        System.out.println(leetCodeOffer05.replaceSpace(s));

    }

    public String replaceSpace(String s) {

        int len = s.length();
//        构建长度为字符串长度三倍的字符数组
        char[] temp = new char[len * 3];
        char c = ' ';
        int size = 0;

//        遍历该字符串
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
//            判断
            if (c == ' ') {
                temp[size++] = '%';
                temp[size++] = '2';
                temp[size++] = '0';
            } else {
                temp[size++] = c;
            }
        }
//        转为字符串
        String s1 = new String(temp, 0, size);
        return s1;
    }
}
