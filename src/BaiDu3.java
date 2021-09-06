import java.util.*;
class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int index = 1;
        while (count-- >= 1){
            String str = sc.next();
            System.out.println(str);

            String[] strings = str.split("\\.");
            System.out.println(strings.length);
            int[] arr =
                    Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();
            System.out.println(arr[0]);
//            int i = Integer.parseInt(str.substring(0, 4));
//            System.out.println(i);
//            String wei;
//            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
//                wei = "Yes";
//            }else {
//                wei = "No";
//            }
//            System.out.println("Case % " + index++ + ":" + wei);
        }

    }
}