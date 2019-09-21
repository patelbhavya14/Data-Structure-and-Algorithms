package sorting;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = new int[10];

    QuickSort(int a[]) {
        arr = a;
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int a[], int l, int h) {
        if(h<=l) return;

        int pivot = partition(a, l, h);
        quickSort(a, l, pivot-1);
        quickSort(a, pivot+1, h);
    }

    public static int partition(int a[], int l, int h) {
        int pivot = h;
        int counter = l;
        for(int i=l; i<h; i++) {
            if(arr[i]<arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }
}
