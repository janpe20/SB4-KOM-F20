package com.company;

import static com.company.InsertionSort.printArray;

public class Main {

    public static void main(String[] args) {
        int arr[] = {5, 2, 4, 6, 1, 3};
        InsertionSort sort = new InsertionSort();
        sort.sort(arr);
        printArray(arr);
    }
}
