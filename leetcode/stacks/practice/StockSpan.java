package leetcode.stacks.practice;

import java.util.Stack;

/**
 * Stock Span Problem
 * =====================
 * Stock is nothing but the price of the given entity.
 * Span is the maximum no of consecutive days for which
 * -> price <= today's price
 * 
 * Stock Span Problem calculates, for each day, the maximum number of
 * consecutive days (including the current day) that the stock price was less
 * than or equal to the current day's price.
 * 
 * It is a classic application of a Monotonic Stack.
 */
public class StockSpan {
    public static void stockSpan(int[] stocks, int[] spans) {
        Stack<Integer> highs = new Stack<>();
        spans[0] = 1;
        highs.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currentPrice = stocks[i];

            while (!highs.isEmpty() && currentPrice > stocks[highs.peek()]) {
                highs.pop();
            }

            if (highs.isEmpty()) {
                spans[i] = i + 1;
            } else {
                int previousHigh = highs.peek();
                spans[i] = i - previousHigh;
            }

            highs.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int spans[] = new int[stocks.length];

        stockSpan(stocks, spans);

        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
