package com.list;

public class Employee {
    String firstName;
    String lastName;
    int id;

    //Constructor Function
    Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //Override equals method to actually compare all variables within the class rather than just
    //checking if the instantiation is exactly the same which would return false
    //Should also override the hashCode() method which I did not here
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!firstName.equals(employee.firstName)) return false;
        return lastName.equals(employee.lastName);

    }

    //Override toString method to print out employees like this
    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName +'\'' +
                ", id=" + id +
                '}';
    }
}