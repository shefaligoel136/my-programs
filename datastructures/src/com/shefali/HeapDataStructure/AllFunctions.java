package com.shefali.HeapDataStructure;

public class AllFunctions {
    static int count = 9;
    static int capacity = 15;

    public static void insert(int arr[], int key) {// for min_heap
        count++;
        int i = count;
        while (i > 0 && key < arr[(i - 1) / 2]) {
            arr[i] = arr[(i - 1) / 2];
                i = (i - 1) / 2;
        }
        arr[i] = key;

    }

    public static void delete(int arr[]) {
        arr[0] = arr[count];
        count--;
        percolateUp(arr, 0);
    }

    public static void percolateUp(int arr[], int i) { //for min_heap
        int max;
        int l = findLeftChildren(arr, i);
        int r = findRightChildren(arr, i);
        if (l != -1 && r != -1) {
            if (arr[l] < arr[i] && arr[l] < arr[r])
                max = l;
            else
                max = i;
            if (arr[r] < arr[i] && arr[r] < arr[l])
                max = r;
            if (max != i) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
                percolateUp(arr, max);
            }
        }
    }

    public static void percolateDown(int arr[], int i) { // for max_heap
        int max;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l != -1 && arr[l] > arr[i])
            max = l;
        else
            max = i;
        if (r != -1 && arr[r] > arr[i])
            max = r;
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            percolateDown(arr, max);
        }

    }

    public static void deleteArbitrary(int arr[], int key) {
        for (int i = 0; i <= count; i++) {
              if(arr[i]==key) {
                  arr[i] = arr[count];
                  percolateUp(arr, i);
              }
        }
    }

    public static int findParent(int arr, int value) {
        return (value - 1) / 2;
    }

    public static int findLeftChildren(int arr[], int value) {
        int left = 2 * value + 1;
        if (left >= count)
            return -1;
        return left;
    }

    public static int findRightChildren(int arr[], int value) {
        int right = 2 * value + 2;
        if (right >=count)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[capacity];
       arr[0] = 2;
       arr[1] = 3;
       arr[2] = 4;
       arr[3] = 9;
       arr[4] = 7;
       arr[5] = 6;
       arr[6] = 11;
       arr[7] = 15;
       arr[8] = 21;
       arr[9] = 23;
        insert(arr, 1);
        System.out.print("{");
        for (int i = 0; i <= count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");

        delete(arr);
        System.out.println();
        System.out.print("{");
        for (int i = 0; i <= count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");

        deleteArbitrary(arr, 9);
        count--;
        System.out.println();
        System.out.print("{");
        for (int i = 0; i <= count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");

    }

}
