package com.awapps.advancedmath;

import com.awapps.advancedmath.calculate.CNumber;
import com.awapps.advancedmath.calculate.equation.ExpressionEvaluator;

public class Test {
    public static String getCosContent(String input) {
        int start = input.indexOf("cos(") + 4; // Start right after 'cos('
        int bracketCount = 1;
        StringBuilder result = new StringBuilder();

        for (int i = start; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') bracketCount++;
            if (c == ')') bracketCount--;

            if (bracketCount == 0) break; // We found the matching closing bracket
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ExpressionEvaluator("y=x").evaluateAt(CNumber.parseNumber(10)));
    }
}
