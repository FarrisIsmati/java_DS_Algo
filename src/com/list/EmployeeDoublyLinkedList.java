package com.list;

public class EmployeeDoublyLinkedList {
    EmployeeDoublyNode head;
    EmployeeDoublyNode tail;
    private int size = 0;

    public void addToFront(Employee employee) {
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            EmployeeDoublyNode oldHead = head;
            oldHead.previous = node;
            head = node;
            head.next = oldHead;
            size++;
        }
    }

    public void addToTail(Employee employee) {
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            EmployeeDoublyNode oldTail = tail;
            oldTail.next = node;
            tail = node;
            tail.previous = oldTail;
            size++;
        }
    }

    public EmployeeDoublyNode removeFromFront() {
        if (head == null) {
            return null;
        }

        EmployeeDoublyNode removedHead = head;

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = removedHead.next;
            head.previous = null;
        }

        size--;
        return removedHead;
    }

    public EmployeeDoublyNode removeFromTail() {
        if (tail == null) {
            return null;
        }

        EmployeeDoublyNode removedTail = tail;

        if (tail.previous == null) {
            tail = null;
            head = null;
        } else {
            tail = removedTail.previous;
            tail.next = null;
        }

        size--;
        return removedTail;
    }

    public boolean addBefore(Employee employee, Employee existingEmployee) {
        if (isEmpty()){
            return false;
        }

        EmployeeDoublyNode targetNode = new EmployeeDoublyNode(existingEmployee);
        EmployeeDoublyNode insertNode = new EmployeeDoublyNode(employee);
        EmployeeDoublyNode current = head;

        while (targetNode.employee != current.employee) {
            current = current.next;
            if (current == null){
                return false;
            }
        }

        if (current.employee == head.employee) {
            EmployeeDoublyNode oldHead = head;
            head = insertNode;
            head.next = oldHead;
            oldHead.previous = head;
        } else {
            EmployeeDoublyNode prevNode = current.previous;
            prevNode.next = insertNode;
            insertNode.previous = prevNode;
            insertNode.next = current;
            current.previous = insertNode;
        }

        return true;
    }

    public void printList() {
        EmployeeDoublyNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    public int size() {
        return size;
    }
}
