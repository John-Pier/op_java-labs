package models;

import java.util.*;

public class SortedStack implements CustomStack<Double> {
    private Stack<Double> stack = new Stack<>();
    private Stack<Double> helpStack = new Stack<>();

    public SortedStack() {

    }

    @Override
    public void push(Double item) {
        if (this.stack.empty() || this.stack.peek() > item) {
            this.stack.push(item);
            return;
        }
        this.stack.push(item);
        this.resortStack();
    }

    private void resortStack() {


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
