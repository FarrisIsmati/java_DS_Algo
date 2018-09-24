package com.sort;

//Java approach a bit different. Modifying/Resorting original input array over many recursive iterations until
//the whole is sorted.
//In JS I keep making copies of the array and splitting subsets of that copy and end up returning a brand new array
//Definitely more confusing than making copies of an array, but this seems faster (more memory efficient)
public class MergeSort {
    public static void mergeSort(int[] input, int start, int end) {
        //The moment you have a one element array stop the recursion
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge (int[] input, int start, int mid, int end) {
        //If last element in left partition is less than
        //The first element in the right partition
        //Then they are already merged so return and move on
        if (input[mid - 1] < input[mid]) {
            return;
        }

        //For left array index
        int i = start;
        //For right array index
        int j = mid;
        int tempIndex = 0;

        //Temp array is large enough to hold combined subset arrays
        int[] temp = new int[end - start];

        //Loop through your current subset within the array when one maxes out stop looping
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        //Only push into elements in the left array because they are already greater than everything that's on the right array
        //No need to push in the right array because they are already there
        while (i < mid) {
            temp[tempIndex++] = input[i++];
        }

        while (j < end) {
            temp[tempIndex++] = input[j++];
        }

        //If you have left over elements in left array copy them from the position you left them at (i) into the last position you added values (tempIndex) length
        //Mid - i will show how many leftover elements there are in the left array

        //DOING THIS BECAUSE YOU DIDN"T PUSH IN LEFTOVER RIGHT ELEMENTS (ITS AN OPTIMIZATION FEATURE THATS A TAD COMPLICATED) ???
        //System.arraycopy(input, i, input, start + tempIndex, mid - i);

        //Copy everything we put into the tempIndex into the OG array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
