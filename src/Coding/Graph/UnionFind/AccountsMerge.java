package Coding.Graph.UnionFind;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/
// https://www.youtube.com/watch?v=wU6udHRIkcc
// There are multiple things that you need to do in this question
// 1.create a hashmap which contains emailIds with index - use of union method
//    if the key is already present do union find with the old key and new key
// 2. Get all email ids based on the index - use of absoluteParent method
//     0 index -> will contain all merge id
// 3. Merge all accounts - sort them and also add name to every list index 0
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        // 1. HashMap - union find operation
        HashMap<String, Integer> emailToFirstAccountId = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            List<String> emailIds = account.subList(1, account.size());
            for (String emailID : emailIds) {
                if (!emailToFirstAccountId.containsKey(emailID)) {
                    emailToFirstAccountId.put(emailID, i);
                } else {
                    // do unification
                    Integer previousId = emailToFirstAccountId.get(emailID);
                    unionFind.union(previousId, i);// join together
                }
            }
        }
        //  Store emails corresponding to the component's representative
        // index -> merged email id
        Map<Integer, List<String>> components = new HashMap<>();
        for (String emailId : emailToFirstAccountId.keySet()) {
            int group = emailToFirstAccountId.get(emailId);
            int absoluteParent = unionFind.getAbsoluteParent(group);
            components.putIfAbsent(absoluteParent, new ArrayList<>());
            components.get(absoluteParent).add(emailId); // index -> List<email>
        }

        // Sort the components and add the account name
        List<List<String>> resultList = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> integerListEntry : components.entrySet()) {
            List<String> emailIds = integerListEntry.getValue();
            Collections.sort(emailIds);
            // get name from original list that is passed in input
            String accountName = accounts.get(integerListEntry.getKey()).get(0);
            emailIds.add(0, accountName);
            resultList.add(emailIds);
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<String>> arrayList = new ArrayList<>();
        arrayList.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        arrayList.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        arrayList.add(Arrays.asList("Mary", "mary@mail.com"));
        arrayList.add(Arrays.asList("John", "johnnybravo@mail.com"));
        List<List<String>> lists = new AccountsMerge().accountsMerge(arrayList);
        System.out.println(lists);
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        private void union(int x, int y) {
            int pX = getAbsoluteParent(x);
            int pY = getAbsoluteParent(y);
            if (pX != pY) {
                parent[pX] = pY;
            }
        }

        private int getAbsoluteParent(int i) {
            if (parent[i] == i) {
                // absolute parent
                return i;
            }
            parent[i] = getAbsoluteParent(parent[i]);
            return parent[i];
        }
    }

}
