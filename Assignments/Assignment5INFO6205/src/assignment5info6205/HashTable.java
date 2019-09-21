/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5info6205;

/**
 *
 * @author bhaVYa
 */
public class HashTable {
    private int m;
    private int n;
    private String values[];
    
    HashTable(int size) {
        values = new String[size];
        this.m = size;
    }
    
    public int getM() {
        return m;
    }
    
    public void add(int key, String val) {
        values[hashValue(key)] = val;
        this.n++;
    }

    public int hashValue(int key) {
        int i = 0;
        int hash = (key+i)%this.m;

        while(values[hash] != null) {
            i++;
            hash = (key+i)%this.m;
        }
        return hash;
    }

    public void displayHashTable() {
        System.out.print("| ");
        for(String s: values) {
            System.out.print(s+" | ");
        }
        System.out.println();
    }

    public double loadFactor() {
        return (double)this.n/this.m;
    }

    public int search(String val) {
        int searchProbe = 0;
        int i = 0;
        int v = Integer.parseInt(val);
        int index = (v+i)%this.m;

        if(values[index] == null) {
            searchProbe++;
            return -1;
        } else {
            if(values[index].equals(val)) {
                searchProbe++;
                return searchProbe;
            } else {
                searchProbe++;
                for(i=1; i<this.m; i++) {
                    index = (v+i)%this.m;
                    searchProbe++;
                    if(values[index] == null){
                        return -1;
                    } else if(values[index].equals(val)) {
                        return searchProbe;
                    }
                }
            }
        }
        return -1;
    }
}
