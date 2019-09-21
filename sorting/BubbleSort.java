package sorting;

import java.util.Arrays;

public class BubbleSort {
    static int[] arr = new int[10];

    BubbleSort(int[] a) {
        arr = a;
        bubbleSort(arr);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int a[]) {
        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for(int i=0; i<a.length-1; i++) {
                if(a[i] > a[i+1]) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
