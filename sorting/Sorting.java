package sorting;

import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int arr[] = new int[10];

        Random r = new Random();
        for(int i=0 ; i<10; i++) {
            arr[i] = r.nextInt(1000)+1;
        }

        System.out.println("BUBBLE SORT");
        System.out.println("--------------");
        new BubbleSort(arr);
        System.out.println("====================================================");

        System.out.println("INSERTION SORT");
        System.out.println("--------------");
        new InsertionSort(arr);
        System.out.println("====================================================");

        System.out.println("SELECTION SORT");
        System.out.println("--------------");
        new SelectionSort(arr);
        System.out.println("====================================================");

        System.out.println("QUICK SORT");
        System.out.println("--------------");
        new QuickSort(arr);
        System.out.println("====================================================");

        System.out.println("HEAP SORT");
        System.out.println("--------------");
        new HeapSort(arr);
        System.out.println("====================================================");

    }
}
