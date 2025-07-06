import java.util.*;

public class CourseScheduleIV {
    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        System.out.println(checkIfPrerequisite(numCourses1, prerequisites1, queries1)); // [false, true]

        int numCourses2 = 3;
        int[][] prerequisites2 = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries2 = {{1, 0}, {1, 2}};
        System.out.println(checkIfPrerequisite(numCourses2, prerequisites2, queries2)); // [true, true]
    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] graph = new boolean[numCourses][numCourses];

        for (int[] pre : prerequisites) {
            graph[pre[0]][pre[1]] = true;
        }

        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(graph[query[0]][query[1]]);
        }
        return result;
    }
}
