package com.list;

public class EmployeeNode {
    Employee employee;
    EmployeeNode next;

    EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
