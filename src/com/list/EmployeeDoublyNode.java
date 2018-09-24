package com.list;

public class EmployeeDoublyNode {
    Employee employee;
    EmployeeDoublyNode next;
    EmployeeDoublyNode previous;

    EmployeeDoublyNode(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
