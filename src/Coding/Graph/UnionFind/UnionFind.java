package Coding.Graph.UnionFind;

// https://www.youtube.com/watch?v=wU6udHRIkcc - 15:00 array method is explained
public class UnionFind {
    int[] parent;

    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Also known as find operation
    // used for finding out the element belongs to which set
    public int getAbsoluteParent(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = getAbsoluteParent(i);
        return parent[i];
    }

    // if two numbers belong to same set it means there is a cycle
    public void union(int x, int y) {
        int pX = getAbsoluteParent(x);
        int pY = getAbsoluteParent(y);
        if (pX != pY) {
            parent[pX] = pY;
        }
    }

}
