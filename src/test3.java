import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int len = in.nextInt();
        Cao[] caos = new Cao[len];
        for (int i = 0; i < len; i++) {
            caos[i] = new Cao();
            caos[i].opt = in.nextInt();
            if (caos[i].opt == 1) {
                caos[i].app = in.nextLine();
            } else {
                caos[i].index = in.nextInt();
            }
        }
        for (int i = 0; i < caos.length; i++) {
            if (caos[i].opt == 1) {
                sb.append(caos[i].app);
            } else {
                if (caos[i].index - 1 == 0) {
                    System.out.println(findRight(sb, caos[i].index - 1));
                } else if (caos[i].index == sb.length()) {
                    System.out.println(findLeft(sb, caos[i].index - 1));
                } else {
                    System.out.println(Math.min(findLeft(sb, caos[i].index - 1),
                            findRight(sb, caos[i].index - 1)));
                }
            }
        }
    }

    static int findLeft(StringBuilder sb, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (sb.charAt(i) == sb.charAt(index)) {
                return index - i;
            }
        }
        return -1;
    }

    static int findRight(StringBuilder sb, int index) {
        for (int i = index + 1; i < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(index)) {
                return i - index;
            }
        }
        return -1;
    }
}

class Cao {
    public int opt;
    public int index;
    public String app;
}
