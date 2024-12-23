The code fails when \( n = \text{Integer.MIN\_VALUE} \) because of the following issue:

### Problem: Overflow when negating `n`
In Java, the value of `Integer.MIN_VALUE` is \( -2^{31} \), and the value of `Integer.MAX_VALUE` is \( 2^{31} - 1 \). When you negate `Integer.MIN_VALUE` (i.e., `n = -n`), it results in an integer overflow because there is no positive counterpart for `Integer.MIN_VALUE` in a 32-bit integer range.

Here's why:
- \( -(\text{Integer.MIN\_VALUE}) = -(-2^{31}) = 2^{31} \), but \( 2^{31} \) cannot be represented as a 32-bit signed integer (which has a range of \( -2^{31} \) to \( 2^{31} - 1 \)).
- As a result, \( n = -n \) causes `n` to remain as \( \text{Integer.MIN\_VALUE} \), leading to incorrect logic in your code.

### Solution
To handle this case correctly, you can avoid directly negating \( n \) when \( n = \text{Integer.MIN\_VALUE} \). Instead, you need to account for the edge case explicitly.
