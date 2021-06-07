package 回溯.排列组合;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 复原IP地址
 */
public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12 || s.length() <= 3) {
            return res;
        }
        ArrayDeque<String> path = new ArrayDeque<>(4);
        dfs(s,s.length(),0,4,path,res);
        return res;
    }

    private void dfs(String s, int len, int begin, int reside,
                     Deque<String> path, List<String> res) {
        if (begin == len) {
            //如果够4部分ip了
            if (reside == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            //剩余多少部分ip
            //如果剩余太多，直接进入下一轮i+1
            if (reside * 3 < len - i) {
                continue;
            }
            //如果从begin到i可构成一节ip
            if (judgeIpSegment(s,begin,i)){
                //包前不包后，所以i+1
                String substring = s.substring(begin, i + 1);
                path.addLast(substring);
                dfs(s,len,i+1,reside-1,path,res);
                path.removeLast();
            }

        }
    }

    //判断left到right之间是否能构成一个ip的结点
    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        //如果该部分不是个位数且第一位数是0
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
