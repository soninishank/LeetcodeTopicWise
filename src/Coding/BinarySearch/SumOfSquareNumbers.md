# Problem: Sum of Square Numbers
### https://leetcode.com/problems/sum-of-square-numbers/

Given a non-negative integer `c`, determine whether there are two integers `a` and `b` such that \( a^2 + b^2 = c \).

### Example

**Example 1**:
- Input: `c = 5`
- Output: `true`
- Explanation: \( 1^2 + 2^2 = 5 \)

**Example 2**:
- Input: `c = 3`
- Output: `false
- Explanation: No two integers squared add up to 3.

**Example 3**:
- Input: `c = 2147483600`
- Output: `true`
- Explanation: \( 10792^2 + 46340^2 = 2147483600 \)

## Intuition

To determine if a non-negative integer `c` can be expressed as the sum of two squares, \( a^2 + b^2 = c \), consider the following approach:

### Key Observations

1. **Range of Possible Values for `a` and `b`**:
    - Since both `a` and `b` are non-negative, `a^2` and `b^2` must be less than or equal to `c`.
    - This limits `a` and `b` to values between `0` and \( \sqrt{c} \).

2. **Two-pointer Approach**:
    - Start with two pointers:
        - `low` initialized to `0`.
        - `high` initialized to the integer value of \( \sqrt{c} \).
    - Calculate `sumOfSquares = low^2 + high^2` and compare it with `c`:
        - If `sumOfSquares == c`, we’ve found integers `a` and `b` that satisfy the equation, so we return `true`.
        - If `sumOfSquares < c`, we need a larger sum, so increase `low` to make `low^2` larger.
        - If `sumOfSquares > c`, we need a smaller sum, so decrease `high` to make `high^2` smaller.

### Efficiency
- This approach has a time complexity of \( O(\sqrt{c}) \) because each pointer moves within the range from `0` to \( \sqrt{c} \), allowing us to test possible values efficiently.

## Solution Code

To avoid overflow issues, we use `long` for `low`, `high`, and `sumOfSquares`, as squaring values near `c`’s upper bounds (close to `Integer.MAX_VALUE`) can exceed the 32-bit integer limit.

Here’s the solution in Java:

```java
public class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c);  // Using long to prevent overflow

        while (low <= high) {
            long sumOfSquares = low * low + high * high;

            if (sumOfSquares == c) {
                return true;  // Found integers a and b such that a^2 + b^2 = c
            } else if (sumOfSquares < c) {
                low++;  // Increase low to make the sum larger
            } else {
                high--;  // Decrease high to make the sum smaller
            }
        }

        return false;  // No such pair found
    }
}
