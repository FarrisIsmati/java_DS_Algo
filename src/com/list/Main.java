package com.list;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", "Doe", 123);
        Employee emp2 = new Employee("Jahn", "Doe", 124);
        Employee emp3 = new Employee("Jxhn", "Dxe", 134);
        Employee billEnd = new Employee("Bill", "End", 78);
//        System.out.println("Linked List");
//        //LINKED LIST

//
//        EmployeeLinkedList ell = new EmployeeLinkedList();
//
//        ell.addToFront(emp1);
//        ell.addToFront(emp2);
//        ell.addToFront(emp3);
//
//        ell.printList();
//        System.out.println(ell.size());
//
//        System.out.println(ell.isEmpty());
//
//        ell.removeFromFront();
//        ell.removeFromFront();
//        System.out.println(ell.size());
//        System.out.println(ell.isEmpty());
//        ell.printList();

//        System.out.println("Doubly Linked List");
//        //DOUBLY LINKED LIST
//        EmployeeDoublyLinkedList doublyLinkedList = new EmployeeDoublyLinkedList();
//        doublyLinkedList.addToTail(emp1);
//        doublyLinkedList.addToTail(emp2);
//        doublyLinkedList.addToTail(emp3);
//        System.out.println(doublyLinkedList.addBefore(billEnd, emp1));
//
//        doublyLinkedList.printList();

//        LinkedList<Employee> list = new LinkedList<>();
//
//        list.addFirst(emp1);
//        list.addFirst(emp2);
//        list.addFirst(emp3);
//
//        Iterator iter = list.iterator();
//
//        while (iter.hasNext()){
//            System.out.print(iter.next());
//        }
//
//        list.add(billEnd);
//
//        iter = list.iterator();
//        System.out.println("Head ->");
//        while (iter.hasNext()){
//            System.out.print(iter.next());
//        }

        //INTEGER LINKED LIST
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;
        Integer ten = 10;
        Integer eleven = 11;
        Integer eight = 8;
        Integer neg1 = -1;
        Integer four2 = 4;
        Integer five = 5;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();
        list.insertSorted(four2);
        list.printList();
        list.insertSorted(ten);
        list.printList();
        list.insertSorted(eleven);
        list.printList();
        list.insertSorted(eight);
        list.printList();
        list.insertSorted(neg1);
        list.printList();
        list.insertSorted(five);
        list.printList();
        list.insertSorted(12);
        list.printList();

    }
}
