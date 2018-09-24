package com.list;

public class EmployeeLinkedList {
    EmployeeNode head;
    private int size = 0;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.next = this.head;
        this.head = node;
        size++;
    }

    public void printList() {
        EmployeeNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;
        head = removedNode.next;
        size--;
        return removedNode;
    }

    public int size() {
        return size;
    }
}
