import java.util.*;

public class MergeIntervals {
    public static void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        sortIntervals(intervals);
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.print("[" + result[i][0] + ", " + result[i][1] + "] ");
        }
    }
}
