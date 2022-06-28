E.g : File size = 8 GB, Ram Size = 2 GB
1.chunk size = file size / ram size 
             = 8 / 2 = 4
2. sort each chunk one by one and place it back to the disk 
3. Apply Merge k sorted list - using priority queue - which occupies only O(K) time complexity

Space Complexity :O(k), If Output is not stored then the only space required is the Min-Heap of k elements. So space Complexity is O(k).

c - no of chunks
s - no of elements in each chunk 
Time complexity - O(cs log s + cs log c)


You are looking for external sorting. The largest cost in these scenarios is often disk IO. So the trick is to use an algorithm that minimises disk IO. The usual approach is to read suitably large chunks in to memory, sort those chunks, saving them back to disk, then merge the sorted chunks.

 "external sorting" or "sort merge".