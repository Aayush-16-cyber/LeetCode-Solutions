import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int neighbor : graph[course]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites1 = {{1, 0}};
        System.out.println(canFinish(2, prerequisites1)); // true

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prerequisites2)); // false

        int[][] prerequisites3 = {};
        System.out.println(canFinish(1, prerequisites3)); // true
    }
}
