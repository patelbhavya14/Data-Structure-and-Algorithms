package sorting;

import java.util.Arrays;

public class HeapSort {
    static int[] arr = new int[10];

    HeapSort(int[] a) {
        arr = a;
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int a[]) {
        for(int i=(a.length/2)-1; i>=0; i--) {
            heapify(a, a.length, i);
        }

        for(int i=a.length-1; i>=0; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;

            heapify(a, i, 0);
        }
    }

    static void heapify(int a[], int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && a[largest]<a[l])
            largest = l;

        if(r<n && a[largest]<a[r])
            largest = r;

        if(largest != i) {
            int swap = a[largest];
            a[largest] = a[i];
            a[i] = swap;

            heapify(a, n, largest);
        }
    }
}
