import java.util.*;

public class ReconstructItinerary {
    static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    static LinkedList<String> itinerary = new LinkedList<>();

    public static void main(String[] args) {
        List<List<String>> tickets1 = Arrays.asList(
            Arrays.asList("MUC", "LHR"),
            Arrays.asList("JFK", "MUC"),
            Arrays.asList("SFO", "SJC"),
            Arrays.asList("LHR", "SFO")
        );

        List<List<String>> tickets2 = Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
        );

        System.out.println("Itinerary 1: " + findItinerary(tickets1)); // ["JFK","MUC","LHR","SFO","SJC"]
        System.out.println("Itinerary 2: " + findItinerary(tickets2)); // ["JFK","ATL","JFK","SFO","ATL","SFO"]
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        graph.clear();
        itinerary.clear();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK");
        return itinerary;
    }

    private static void dfs(String airport) {
        PriorityQueue<String> dests = graph.get(airport);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll());
        }
        itinerary.addFirst(airport);
    }
}
