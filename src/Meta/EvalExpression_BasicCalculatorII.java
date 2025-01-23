package Meta;

public class EvalExpression_BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0; // Final result
        int currentNumber = 0; // Current number being processed
        int lastValue = 0; // Last evaluated value for multiplication/division
        char operation = '+'; // Last operation
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            // Process operation if we encounter an operator or reach the end of the string
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == chars.length - 1) {
                switch (operation) {
                    case '+':
                        result += lastValue; // Add the last value to the result
                        lastValue = currentNumber; // Update last value
                        break;
                    case '-':
                        result += lastValue;
                        lastValue = -currentNumber;
                        break;
                    case '*':
                        lastValue *= currentNumber; // update lastValue directly without affecting a result
                        break;
                    case '/':
                        lastValue /= currentNumber; // update lastValue directly without affecting a result
                        break;
                }
                operation = currentChar; // Update current operation
                currentNumber = 0; // Reset current number
            }
        }
        result += lastValue; // Add the last pending value to the result
        return result;
    }


    public static void main(String[] args) {
        int calculate = new EvalExpression_BasicCalculatorII().calculate("3+5*2-8/4");
        System.out.println(calculate);
    }
}

// 3 + (5*2) - (8/4)
// 3 + 10 - 2
// 13 - 2
// 11