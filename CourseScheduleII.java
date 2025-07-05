import java.util.*;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;
            for (int neighbor : graph[course]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return idx == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(Arrays.toString(findOrder(2, prerequisites1))); // [0, 1]

        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites2))); // [0,2,1,3] or [0,1,2,3]

        int[][] prerequisites3 = {};
        System.out.println(Arrays.toString(findOrder(1, prerequisites3))); // [0]
    }
}
