import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                parent.put(email, email);
                owner.put(email, name);
            }
        }

        for (List<String> acc : accounts) {
            String first = acc.get(1);
            for (int i = 2; i < acc.size(); i++) {
                union(parent, first, acc.get(i));
            }
        }

        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(root));
            merged.addAll(unions.get(root));
            result.add(merged);
        }

        return result;
    }

    private String find(Map<String, String> parent, String s) {
        if (!s.equals(parent.get(s)))
            parent.put(s, find(parent, parent.get(s)));
        return parent.get(s);
    }

    private void union(Map<String, String> parent, String s1, String s2) {
        parent.put(find(parent, s1), find(parent, s2));
    }

    public static void main(String[] args) {
        AccountsMerge solution = new AccountsMerge();
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        input.add(Arrays.asList("Mary", "mary@mail.com"));
        input.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> merged = solution.accountsMerge(input);
        for (List<String> acc : merged) {
            System.out.println(acc);
        }
    }
}
