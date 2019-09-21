package searching;
import java.util.Random;

public class HashingLinearProbing {
    static double loadFactor;
    static int hashTableCapacity = 5;
    public static void main(String[] args) {
            int arrSize = 95;
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
                System.out.println(size);
                hashTableCapacity = 5;
                loadFactor = size;
                System.out.println("----------------------------------");
                Hash hashTable = new Hash(size);
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


    static HashTable rehashing() {
        hashTableCapacity *= 2;
        HashTable hash = new HashTable(hashTableCapacity, loadFactor);
        return hash;
    }
}
