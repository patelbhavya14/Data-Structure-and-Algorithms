package sorting;

import java.util.Arrays;

public class InsertionSort {
    static int[] arr = new int[10];

    InsertionSort(int a[]) {
        arr = a;
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int a[]) {
        for(int i=1; i<a.length; i++) {
            int current = a[i];
            int j = i-1;
            while(j>=0 && current<a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = current;
        }
    }
}
