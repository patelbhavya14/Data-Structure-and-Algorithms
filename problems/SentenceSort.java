package problems;

import java.util.ArrayList;
import java.util.List;

public class SentenceSort {
    public static void main(String[] args) {
        String s = "It is going to be a cracking.";

        List<String> list = new ArrayList<String>();
        int words = 1;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') words++;
        }

        String arr[] = new String[words];
        int t = 0;
        for(int i=0; i<s.length(); i++) {
            String temp = "";
            while(s.charAt(i) != ' ') {
                if(s.charAt(i) == '.') {
                    break;
                }
                temp += String.valueOf(s.charAt(i));
                i++;
            }
            arr[t] = temp.toLowerCase();
            t++;
        }


        boolean isSorted = false;
        String temp;
        while(!isSorted) {
            isSorted = true;
            for(int i=0; i<arr.length-1; i++) {
                if(arr[i].length() > arr[i+1].length()) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                }
            }
        }

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i].length() == arr[j].length()) {
                    if(arr[i].compareTo(arr[j]) > 0) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        String ans = "";

        for(int i=0; i<arr.length; i++) {
            if(i == 0) {
                ans += arr[i].substring(0,1).toUpperCase() + arr[i].substring(1)+" ";
            } else if(i == arr.length - 1) {
                ans += arr[i]+".";
            } else {
                ans += arr[i]+" ";
            }
        }

        System.out.println(ans);
    }
}
