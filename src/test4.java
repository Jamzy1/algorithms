import java.util.*;

import static java.util.Arrays.sort;

public class test4 {

    private static boolean[] visited;
    private static List<List<Integer>> lists;
    private static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        mySort(arr);
        System.out.println(ans);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void mySort(int[] nums) {
        lists = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, track, 0);
    }

    public static void backTrack(int[] nums, LinkedList<Integer> trackList, int index) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(trackList));
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            trackList.add(nums[i]);
            visited[i] = true;
            backTrack(nums, trackList, index + 1);
            visited[i] = false;
            trackList.remove(index);
        }
    }
}
