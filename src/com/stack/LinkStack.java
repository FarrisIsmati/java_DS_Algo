package com.stack;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkStack {
    private LinkedList<Character> stack;

    public LinkStack() {
        stack = new LinkedList<Character>();
    }

    public void push(Character val) {
        stack.push(val);
    }

    public int size() {
        return stack.size();
    }

    public Character pop() {
        return stack.pop();
    }

    public Character peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Character> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
