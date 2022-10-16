package models;

import java.util.*;

public class SortedStack implements CustomStack<Double> {
    private Stack<Double> stack = new Stack<>();
    private Stack<Double> helpStack = new Stack<>();

    public SortedStack() {}

    public SortedStack(Double[] array) {
        for (Double item: array) {
            this.push(item);
        }
    }

    @Override
    public void push(Double item) {
        while (!this.stack.isEmpty() && item > this.stack.peek()) {
            this.helpStack.push(this.stack.pop());
        }
        this.stack.push(item);
        while (!this.helpStack.isEmpty()) {
            this.stack.push(this.helpStack.pop());
        }
    }

    @Override
    public Double pop() throws EmptyStackException {
        return this.stack.pop();
    }

    @Override
    public Double peek() throws EmptyStackException {
        return this.stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
