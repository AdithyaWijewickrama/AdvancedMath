package com.amath.advacedmath;

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

    public static void main(String[] args) {
        System.out.println(getCosContent("cos(x-(s-3)^2-(xx))"));
    }
}
