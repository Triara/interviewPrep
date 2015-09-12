package com.google.dataStructures;

import java.util.Stack;

public class stackWithMinValue extends Stack<Integer> {
    Stack<Integer> minValues;

    public stackWithMinValue() {
        minValues = new Stack<>();
    }

    public Integer pop() {
        Integer removedElement = super.pop();
        if (removedElement == min()) {
            minValues.pop();
        }

        return removedElement;
    }

    public void push(int elementToAdd) {
        super.push(elementToAdd);
        if (elementToAdd <= min()) {
            minValues.push(elementToAdd);
        }
    }

    public Integer min() {
        if (minValues.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minValues.peek();
    }
}
