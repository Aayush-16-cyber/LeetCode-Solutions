import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) return;
        visited[room] = true;

        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }

    // For testing
    public static void main(String[] args) {
        KeysAndRooms sol = new KeysAndRooms();

        List<List<Integer>> rooms1 = List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of()
        );

        List<List<Integer>> rooms2 = List.of(
            List.of(1,3),
            List.of(3,0,1),
            List.of(2),
            List.of(0)
        );

        System.out.println(sol.canVisitAllRooms(rooms1)); // true
        System.out.println(sol.canVisitAllRooms(rooms2)); // false
    }
}
