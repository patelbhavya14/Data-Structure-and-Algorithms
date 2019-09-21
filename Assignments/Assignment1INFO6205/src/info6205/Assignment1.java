/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.lang.model.SourceVersion;

/**
 *
 * @author bhaVYa
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String data = "";

        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name:");
        String fileName = in.nextLine();

        String filePath = Paths.get("").toAbsolutePath().toString()+"/src/info6205/" + fileName + ".java"; // returns filepath 
        try {
            Scanner scan = new Scanner(new File(filePath));
            while (scan.hasNextLine()) {
                data = data + scan.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("No such file found");
            return;
        }

        StringTokenizer st = new StringTokenizer(data, "\n"); // Tokenizing file line by line

        CustomLinkedStack stack = new CustomLinkedStack();
        Map<String, Integer> hashMap = new HashMap<String, Integer>(); 

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim(); // Removing extra space

            // Checking for multiline comment
            if (token.startsWith("/*")) {
                while (!token.endsWith("*/")) {
                    token = token.replace(token, "");
                    token = st.nextToken();
                }
                token = token.replace(token, "");
                continue;
            }

            // Check for single line comment
            if (token.startsWith("//")) {
                token = token.replace(token, "");
                continue;
            }
            
            token = token.replaceAll("\".*\"", ""); // Ignoring content inside "" 
            token = token.replaceAll("\'.*\'", ""); // Ignoring content inside ''
            token = token.replaceAll("[\\(\\)\\,\\.\\<\\>\\[\\]\\,\\!\\;\\@\\#\\$\\%\\^\\&\\*\\:\\?\\=]", " "); // Ignoring special characters
            token = token.replace("+", "\n");
            
            token = token.replaceAll("\\/\\/.*", ""); // Ignoring single line comment
            token = token.trim();
            
            
            // Tokenizing token
            StringTokenizer st1 = new StringTokenizer(token, "{} ", true);

            while (st1.hasMoreTokens()) {
                String token1 = st1.nextToken();
                if (token1.equals("{")) {
                    stack.push(token1);
                }

                if (token1.equals("}")) {
                    if (stack.isEmpty()) {
                        System.out.println("It is not valid java class");
                        return;
                    }
                    stack.pop();
                }
                
                // Check for identifier
                if ((SourceVersion.isName(token1))) {
                    System.out.println("");
                    hashMap.put(token1, hashMap.containsKey(token1) ? hashMap.get(token1) + 1 : 1);
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("It is valid java class");
        } else {
            System.out.println("It is not valid java class");
            return;
        }
        System.out.println("=============================");
        int count = 0;
        int freq = 0;

        for (String key : hashMap.keySet()) {
            System.out.println("Identifier: " + key);
            System.out.println("Frequency: " + hashMap.get(key));
            count++;
            freq = freq + hashMap.get(key);
            System.out.println("-----------------------------");
        }
        System.out.println("Total Identifiers: " + count);
        System.out.println("Total frequency: " + freq);
    }
    
}
