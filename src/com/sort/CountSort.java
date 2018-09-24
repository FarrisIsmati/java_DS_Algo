package com.sort;

import java.util.Arrays;

//Linear time sorting algorithim that requires assumptions to be made
//The data must be within a reasonable range positive integers
public class CountSort {
    public static int[] sort(int[] input, int minNum, int maxNum) {
        int[] counter = new int[maxNum - minNum + 1];
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            counter[input[i] - minNum]++;
        }

        int resultIndex = 0;

        for (int x = 0; x < counter.length; x++) {
            while (counter[x]-- > 0){
                result[resultIndex++] = x + minNum;
            }
        }

        return result;
    }
}
