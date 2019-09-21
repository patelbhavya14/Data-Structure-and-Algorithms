package sorting;

import java.util.Arrays;

public class SelectionSort {
    static int[] arr = new int[10];

    SelectionSort(int a[]) {
        arr = a;
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int a[]) {
        for(int i=0; i<a.length-1; i++) {
            int min = a[i];
            int lastIndex = i;
            for(int j=i+1; j<a.length; j++) {
                if(a[j]<min) {
                    min = a[j];
                    lastIndex = j;
                }
            }
            a[lastIndex] = a[i];
            a[i] = min;
        }
    }
}
