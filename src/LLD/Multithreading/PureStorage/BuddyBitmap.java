package LLD.Multithreading.PureStorage;

public class BuddyBitmap {
    private int[] tree; // The tree stored as a 1D array
    private int n; // Total number of nodes

    // Constructor to initialize the tree
    public BuddyBitmap(int[] initialTree) {
        this.tree = initialTree;
        this.n = initialTree.length;
    }

    // Set bits in the range [offset, offset + length - 1]
    public void setBit(int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            tree[i] = 1;
            updateParent(i); // Ensure parent consistency
        }
    }

    // Clear bits in the range [offset, offset + length - 1]
    public void clearBit(int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            tree[i] = 0;
            updateParent(i); // Ensure parent consistency
        }
    }

    // Update the parent nodes recursively
    private void updateParent(int index) {
        if (index == 0) return; // Root node has no parent
        int parent = (index - 1) / 2; // Calculate parent index
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;

        // Update the parent based on its children
        if (rightChild < n) { // If both children exist
            tree[parent] = tree[leftChild] & tree[rightChild];
        } else { // If only left child exists (complete binary tree property)
            tree[parent] = tree[leftChild];
        }

        // Recursively update the parent of the current parent
        updateParent(parent);
    }

    // Print the tree for debugging
    public void printTree() {
        for (int val : tree) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example tree: [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
        int[] initialTree = {0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1};
        BuddyBitmap manager = new BuddyBitmap(initialTree);

        System.out.println("Initial Tree:");
        manager.printTree();

        System.out.println("\nSetting bits from index 4 to 6:");
        // offset means starting index
        // (4,3) means -> (4,4+3-1) -> (4, 6)
        manager.setBit(4, 3); // it means making it to 1
        manager.printTree();

        System.out.println("\nClearing bits from index 8 to 9:");
        manager.clearBit(8, 2);
        manager.printTree();
    }
}
