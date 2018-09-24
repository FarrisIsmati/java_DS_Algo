package com.sort;

public class RadixSort {
    public static void sort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            //i is position of digit eg 1's, 10's, 100's, 1000's because the math expression in get digit works that way
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;

        int[] countArray = new int[radix];

        //Sets up the count array for the digit your are looking at eg 1's 10's 100's 1000's
        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }

        //Adjust count array to have the sum total of values that have that digit or less at each index
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        //The result of sorted order at each digit eg 1's sorted result, 10's sorted result, 100's sorted result, 1000's sorted result
        int[] temp = new int[numItems];

        //Populates the tempArr which is the current sorted result at each digit by getting the digit of the current value you're walking through the input
        //array backwards position within the count array, then decrementing that part of the count array because if you go back to that same value,
        //That digit will be in one index behind the same digit you had thus preserving order making it stable
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        System.arraycopy(temp, 0, input, 0, numItems);
    }

    public static int getDigit(int position, int value, int radix) {
        //Gets the digit based on the digit you want from a number
        //Could just use a pointer and convert the int to an array of single ints and work backwards through it for the position,
        // but this is faster
        return value / (int) Math.pow(radix, position) % radix;
    }
}
