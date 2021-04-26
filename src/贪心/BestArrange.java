package 贪心;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 给一个宣讲室，一次只能进行一个项目(有开始时间和结束时间)，安排时间，使宣讲室完成的项目最多
 *
 * 按哪个项目早结束为标准来安排
 */
public class BestArrange {

    public static void main(String[] args) {

    }

//    项目结构
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

//    比较器，比较哪个项目早结束
    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }

    }

    public static int bestArrange(Program[] programs, int start) {
//        将每个项目按结束时间先后排序
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
//        每次拿到的都是现有项目里结束时间最早的
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                result++;
//                这一步自动淘汰掉结束时间在此之前的
                start = programs[i].end;
            }
        }
        return result;
    }
}
