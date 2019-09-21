/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5info6205;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bhaVYa
 */
public class Analysis {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the value of array size:");
            int n = in.nextInt();
            int arrSize = n;
            int arr[] = new int[arrSize];
            int sizes[] = {(int)(arrSize/0.60), (int)(arrSize/0.65),(int)(arrSize/0.70),
                    (int)(arrSize/0.75),(int)(arrSize/0.80),
                    (int)(arrSize/0.85),(int)(arrSize/0.90),
                    (int)(arrSize/0.95), arrSize};
            Random r = new Random();
            for (int i = 0; i < arr.length; i++) {
                int ele = r.nextInt(999) + 1;
                arr[i] = ele;
            }

            for (int size : sizes) {
                System.out.println("----------------------------------");
                HashTable hashTable = new HashTable(size);
                for (int i = 0; i < arr.length; i++) {
                    hashTable.add(arr[i], String.valueOf(arr[i]));
                }

                //hashTable.displayHashTable();
                int totalSearches = 0;
                for (int i : arr) {
                    totalSearches += hashTable.search(String.valueOf(i));
                }

                System.out.println("LOAD FACTOR=" + hashTable.loadFactor());
                System.out.println("TOTAL SEARCHES=" + totalSearches);
                System.out.println("AVG. NO SEARCHES REQUIRED=" + (double) totalSearches / arr.length);
                System.out.println("=======================================");
            }
    }
}
