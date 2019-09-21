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
public class Assignment5INFO6205 {

    /**
     * @param args the command line arguments
     */
    static int hashTableCapacity;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of hash table");
        hashTableCapacity = in.nextInt();
        
        Random r = new Random();
        int arr[] = new int[hashTableCapacity*2+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(999) + 1;
        }
        double loadFactor = 0.75;
        
        // Linear Probing
        HashTable hashTable = new HashTable(hashTableCapacity);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hashTable.loadFactor() >= loadFactor) {
                hashTable = rehashing();
                i = -1;
                continue;
            }
            hashTable.add(arr[i], String.valueOf(arr[i]));
        }
        hashTable.displayHashTable();
        int totalSearches = 0;
        for (int i : arr) {
            totalSearches += hashTable.search(String.valueOf(i));
        }
        System.out.println("LOAD FACTOR=" + hashTable.loadFactor());
        System.out.println("Total searches: " + totalSearches);
        System.out.println("Average search required: " + (double) totalSearches / arr.length);
        System.out.println("==============================================================");
        
        // Part 2
        System.out.println("BIGGER HASH TABLE");
        HashTable BiggerHashTable = new HashTable(hashTableCapacity*4);
        for(int val: arr) {
            BiggerHashTable.add(val, String.valueOf(val));
        }
        BiggerHashTable.displayHashTable();
        totalSearches = 0;
        for (int i : arr) {
            totalSearches += BiggerHashTable.search(String.valueOf(i));
        }
        System.out.println("LOAD FACTOR=" + BiggerHashTable.loadFactor());
        System.out.println("Total searches: " + totalSearches);
        System.out.println("Average search required: " + (double) totalSearches / arr.length);
    }

    static HashTable rehashing() {
        hashTableCapacity *= 2;
        HashTable hash = new HashTable(hashTableCapacity);
        return hash;
    }
    
}
