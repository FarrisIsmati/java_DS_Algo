package com.heap;

public class Heap {
    private int[] heap;
    private int size;

    //Heap is an array set its capacity
    public Heap(int capacity) {
        heap = new int[capacity];
    }

    //When inserting you check if the cap is full, else start by inserting new value at the bottom of the heap
    //Now iteratively compare your value with its parent to check if its greater than the parent
    //Once proper swaps have been made increment size by 1 (for future reference checking if capacity is full) To preserve the properties of a max heap
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value;
        fixedHeapAbove(size);
        size++;
    }

    public int peek() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]){
            fixedHeapBelow(index, size - 1);
        } else {
            fixedHeapAbove(index);
        }

        size--;

        return deletedValue;
    }

    //Method to check the current index's parent element
    //If the parent is less than the current index's value then swap parent down to new index
    //After swapping is done set new index to new value
    //To preserve the properties of a max heap
    private void fixedHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void fixedHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index < lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }

                index = childToSwap;
            }
        }
    }

    //Checks if the heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    //Function to return the value of the parent from an index
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    //Checks if heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
    }

    //Returns index of a given heap's child (You pass in true for left child, false for right child)
    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;
            fixedHeapBelow(0,lastHeapIndex - i - 1);
        }
    }
}
