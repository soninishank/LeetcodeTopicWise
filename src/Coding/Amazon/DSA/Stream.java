package Coding.Amazon.DSA;


public interface Stream {
    //Returns True if stream contains next element or False if end-of-stream.
    Boolean hasNext();

    // Returns next element of Stream.
    Integer next();
}