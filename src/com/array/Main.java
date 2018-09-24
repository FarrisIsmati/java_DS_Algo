package com.array;

import com.list.Employee;

public class Main {

    public static void main(String[] args) {
//        //MERRGE SORT
//        int[] intArray = { 20, 35, -15, 7, 55, 1, -22, 4, 23, 8, 9, 4, 22, -45, 9, 8, 7, 6, 5, 4, 3 };
//
//        MergeSort mSort = new MergeSort();
//
//        mSort.mergeSort(intArray, 0, intArray.length);
//
//        for (int i = 0; i < intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }

////      QUICK SORT
//        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
//
//        QuickSort qSort = new QuickSort();
//
//        qSort.quickSort(intArray, 0, intArray.length);
//
//        for (int i = 0; i < intArray.length; i++) {
//            System.out.println(intArray[i]);
//        }

//        //COUNT SORT
//        int[] intArray = { 4,2,6,4,4,7, 2, 3,4, 6,8 };
//
//        CountSort cSort = new CountSort();
//
//        System.out.println(
//                Arrays.toString(
//                        cSort.sort(intArray, 2, 8)
//                )
//        );

        //RADIX SORT
//        int[] intArray = { 923, 921, 920, 850, 841, 862 };
//
//        RadixSort rSort = new RadixSort();
//        rSort.sort(intArray, 10, 3);
//
//        System.out.println(
//                Arrays.toString(intArray)
//        );
    }

    //Factorial Recursive
    public static int factorial(int num) {
        return num == 0 ? 1 : num * factorial(num - 1);
    }

}
