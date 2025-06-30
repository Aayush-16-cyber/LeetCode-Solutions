import java.util.*;

public class BusRoutes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map each stop to the buses passing through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.putIfAbsent(stop, new ArrayList<>());
                stopToBuses.get(stop).add(bus);
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        queue.offer(source);
        visitedStops.add(source);

        int busCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            busCount++;

            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                for (int bus : stopToBuses.getOrDefault(currentStop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) continue;

                    visitedBuses.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return busCount;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] routes1 = {{1, 2, 7}, {3, 6, 7}};
        int source1 = 1, target1 = 6;
        System.out.println("Example 1: " + numBusesToDestination(routes1, source1, target1)); // Output: 2

        int[][] routes2 = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int source2 = 15, target2 = 12;
        System.out.println("Example 2: " + numBusesToDestination(routes2, source2, target2)); // Output: -1
    }
}
