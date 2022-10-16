package models;

import java.util.*;

public interface CustomStack<T extends Number> {
    void push(T item);
    T pop() throws EmptyStackException;
    T peek() throws EmptyStackException;
    boolean isEmpty();
}
