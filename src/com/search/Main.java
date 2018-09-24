package com.search;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arrray = { 4, 2, 9, 1, 9, 2, 10, 15, -2, 4, 18};

        Arrays.sort(arrray);

        System.out.println(binarySearch(arrray, 35));
    }

    public static boolean binarySearch(int[] input, int target){
        return search(input, 0, input.length -1, target);
    }

    private static boolean search(int[] input, int start, int end, int target) {
        int mid = (end + start) / 2;

        if (input[mid] == target) {
            return true;
        }

        if (end - start <= 1) {
            return false;
        }

        if (input[mid] > target) {
            return search(input, start, mid, target);
        } else {
            return search(input, mid, end, target);
        }
    }
}
