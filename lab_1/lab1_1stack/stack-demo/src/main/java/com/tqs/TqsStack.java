package com.tqs;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<E> {

    private LinkedList<E> stack;
    private int limit_stack = -1;

    public TqsStack() {
        stack = new LinkedList<E>();
    }

    public TqsStack(int limit) {
        limit_stack = limit;
        stack = new LinkedList<E>();
    }

    void push(E element) {
        if (stack.size() >= limit_stack && limit_stack != -1) {
            throw new IllegalStateException("A pilha está cheia");
        } else {
            stack.add(element);
        }
    }

    void pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("A pilha está vazia");
        } else {
            stack.remove(stack.size() - 1);
        }
    }
    
    E peek() {
        try {
            return stack.get(stack.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException("A pilha está vazia");
        }
    }

    int size() {
        return stack.size();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }
}