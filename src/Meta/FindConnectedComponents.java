package Meta;

import java.util.*;

public class FindConnectedComponents {
    public static List<Set<String>> mergeContacts(Map<String, List<String>> contacts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToContact = new HashMap<>();

        // Build graph and map emails to their contact names
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            String contact = entry.getKey();
            List<String> emails = entry.getValue();

            for (String email : emails) {
                emailToContact.put(email, contact);
                graph.computeIfAbsent(email, k -> new HashSet<>()).addAll(emails);
            }
        }

        Set<String> visited = new HashSet<>();
        List<Set<String>> result = new ArrayList<>();

        // Perform DFS to group connected components
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                Set<String> connectedContacts = new HashSet<>();
                dfs(email, graph, visited, connectedContacts, emailToContact);
                result.add(connectedContacts);
            }
        }

        return result;
    }

    private static void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, Set<String> connectedContacts, Map<String, String> emailToContact) {
        visited.add(email);
        connectedContacts.add(emailToContact.get(email));

        for (String neighbor : graph.getOrDefault(email, new HashSet<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, connectedContacts, emailToContact);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> contacts = new HashMap<>();
        contacts.put("C1", Arrays.asList("bob@yahoo.com", "bob@gmail.com"));
        contacts.put("C2", Arrays.asList("mary@facebook.com"));
        contacts.put("C3", Arrays.asList("bob@gmail.com", "bob_1@hotmail.com"));
        contacts.put("C4", Arrays.asList("bob_1@hotmail.com"));
        contacts.put("C5", Arrays.asList("mary@facebook.com"));
        contacts.put("C6", Arrays.asList("mark@gmail.com"));

        List<Set<String>> mergedContacts = mergeContacts(contacts);

        System.out.println("Merged Contacts:");
        for (Set<String> group : mergedContacts) {
            System.out.println(group);
        }
    }
}
