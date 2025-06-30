import java.util.*;

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();
        
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        bfs(beginWord, endWord, wordSet, adjList, distance);
        backtrack(beginWord, endWord, adjList, distance, new ArrayList<>(), result);
        
        return result;
    }
    
    private static void bfs(String beginWord, String endWord, Set<String> wordSet, 
                     Map<String, List<String>> adjList, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        
        for (String word : wordSet) {
            adjList.put(word, new ArrayList<>());
        }
        adjList.put(beginWord, new ArrayList<>());
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                int currentDistance = distance.get(currentWord);
                List<String> neighbors = getNeighbors(currentWord, wordSet);
                
                for (String neighbor : neighbors) {
                    adjList.get(currentWord).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currentDistance + 1);
                        if (neighbor.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (foundEnd) break;
        }
    }
    
    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originalChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charArray[i] = c;
                String newWord = new String(charArray);
                if (wordSet.contains(newWord) && !newWord.equals(word)) {
                    neighbors.add(newWord);
                }
            }
            charArray[i] = originalChar;
        }
        return neighbors;
    }
    
    private static void backtrack(String beginWord, String endWord, Map<String, List<String>> adjList, 
                           Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(beginWord);
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else {
            for (String neighbor : adjList.get(beginWord)) {
                if (distance.get(neighbor) == distance.get(beginWord) + 1) {
                    backtrack(neighbor, endWord, adjList, distance, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
