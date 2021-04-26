package 字符串;


/**
 * 将字符串转化为整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 *
 * 主要判断边界问题、考虑各种情况
 */
public class LeetCodeOffer67 {

    public static void main(String[] args) {

    }

    public int strToInt(String str) {
//        将字符串去掉首尾空格，并转换为数组
        char[] c=str.trim().toCharArray();
        if (c.length==0){
            return 0;
        }
//        正负号和边界
        int sign=1,binary=Integer.MAX_VALUE/10;
//        答案和遍历指针
        int res=0,i=1;
        if (c[0]=='-'){
            sign=-1;
        }else if(c[0]!='+'){
//            如果没有符号，把起始位标为0
            i=0;
        }
        for (int j = i; j < c.length; j++) {
//            如果不是数字开头，直接返回
            if (c[j]<'0'||c[j]>'9'){
                break;
            }
//            超出边界
            if (res>binary||res==binary&&c[j]>'7'){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return res*sign;
    }

}
