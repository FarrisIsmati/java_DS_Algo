package com.hash;

import com.hash.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Simple HashTable");
        Employee emp1 = new Employee("John", "Doe", 123);
        Employee emp2 = new Employee("Jahn", "Doe", 124);
        Employee emp3 = new Employee("Jxhn", "Dxe", 134);
        Employee emp4 = new Employee("Bill", "End", 78);

        Map<String, Employee> hashMap = new HashMap<>();
        hashMap.put("John", emp1);
        hashMap.put("Jahn", emp2);
        hashMap.put("Jxhn", emp3);
        hashMap.put("Bill", emp4);

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

        System.out.println(hashMap.containsKey("Jahn"));
        System.out.println(hashMap.containsValue(new Employee("samus", "jerry", 42)));
//        ChainedHashtable ht = new ChainedHashtable();
//
//        ht.put("Jahn", emp2);
//        ht.put("Jxhny", emp3);
//        ht.put("Bilz", emp4);
//        ht.remove(("Jxhny"));
//
//        ht.printHashtable();
//
//        System.out.println("Retrieve Bilz : " + ht.get("Bilz"));
//        //System.out.println(ht.get("Bilz"));
    }
}
