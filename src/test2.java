import java.util.Scanner;

public class test2 {

    public static void ten(int num) {

        String ans = "";
        while (num > 0) {
            ans = num % 8 + " " + ans;
            num = num / 8;
        }
        System.out.println(ans);
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String[][] chars = new String[len][len];
        int num = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                chars[i][j] = in.next();
                if(chars[i][j] == "."){
                    num++;
                }
            }
        }
        int[] ans = new int[1];
        infect(chars, 0, 0, ans, num);
        System.out.print(ans[0]);
    }
    static void infect(String[][] chars, int i, int j, int[] ans, int num){
        if(i<0 || j<0 || i>=chars.length || j>=chars.length || chars[i][j] != "."){
            return;
        }
        if(num == 0 && i == chars.length){
            ans[0]++;
        }
        chars[i][j]="#";
        num--;
        infect(chars, i-1,j,ans,num);
        infect(chars, i+1,j,ans,num);
        infect(chars, i,j-1,ans,num);
        infect(chars, i,j+1,ans,num);
    }
}
