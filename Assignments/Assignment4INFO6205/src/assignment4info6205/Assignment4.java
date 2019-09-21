/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4info6205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author bhaVYa
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    static TreeNode root1 = null, root2 = null;
    static int comparision = 0;
    static String searchPattern = "";

    public static void main(String[] args) {

        System.out.println("Enter number of element to be generated:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n <= 0 || n>200) {
            System.out.println("n should be between 1 and 200");
            n = in.nextInt();
        }

        Set<Integer> duplicate = new HashSet<Integer>();
        Random r = new Random();

        // Part 1
        System.out.println("PART-1");
        System.out.println("=======================================");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            int no = r.nextInt(500) + 1;

            while (duplicate.contains(no)) {
                no = r.nextInt(500) + 1;
            }
            duplicate.add(no);
            arr1[i] = no;
        }
        Arrays.sort(arr1);

        root1 = createDecisionTree(arr1, 0, arr1.length - 1);

        TreeTraversal traversal = new TreeTraversal();

        System.out.print("Inorder traversal: ");
        traversal.inorderTraversal(root1);
        System.out.println();
        System.out.print("Preorder traversal: ");
        traversal.preorderTraversal(root1);
        System.out.println();
        System.out.print("Postorder traversal: ");
        traversal.postorderTraversal(root1);
        System.out.println();
        System.out.println("Total number of nodes in decision tree: " + traversal.totalNode);

        duplicate.clear();
        int searchSequence = r.nextInt(n) + 1;
        int search[] = new int[searchSequence];
        for (int i = 0; i < searchSequence; i++) {
            int no = r.nextInt(500) + 1;
            while (duplicate.contains(no)) {
                no = r.nextInt(500) + 1;
            }
            duplicate.add(no);
            search[i] = no;
        }

        System.out.println("----------------------------------------");
        for (int i : search) {
            System.out.println(i + ": " + searchBST(root1, i));
            System.out.println("Search Pattern: " + searchPattern);
            System.out.println("Comparision required: " + comparision);
            searchPattern = "";
            comparision = 0;
            System.out.println("--------------------------------------");
        }

        // Part 2
        System.out.println("PART-2");
        System.out.println("=======================================");
        int prevHeight = 0, diff = 0, sumOfDiff = 0;
        for (int j = 0; j < n; j++) {
            //int k = in.nextInt();
            int k = j + 1;
            duplicate.clear();
            int arr2[] = new int[k];
//            while(k>50 || k<=0) {
//                System.out.println("k should be between 0 to "+n+" only");
//                k = in.nextInt();
//            }

            for (int i = 0; i < k; i++) {
                int no = r.nextInt(n);
                while (duplicate.contains(no)) {
                    no = r.nextInt(n);
                }
                duplicate.add(no);
                arr2[i] = arr1[no];
            }
            Arrays.sort(arr2);
            //root2 = createDecisionTree(arr2, 0, k-1);
            root2 = createBST(arr2, 0, k - 1);
            int h = getHeight(root2);

            if (j > 0) {
                diff = h - prevHeight;
                sumOfDiff += diff;
                if (diff == 0) {
                    System.out.println("k" + (j + 1) + ":" + (j + 1));
                    System.out.print("Inorder traversal: ");
                    traversal.inorderTraversal(root2);
                    System.out.println("");
                    System.out.println("Height of BST: " + h);
                    System.out.println("Difference of height between k" + (j) + " & k" + (j + 1) + " is " + diff);
                    System.out.println("-------------------------------------");
                }
            }
            prevHeight = h;
            root2 = null;
        }
        System.out.println("Average Tree size over n sequence " + ((n * (n + 1)) / 2) / n);
        if (n > 2) {
            System.out.println("Rate of change of difference of height between 1 to " + n + " is " + ((double) (sumOfDiff) / (n - 1)) + " which is as close as 0");
        }
    }

    static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return l < r ? r + 1 : l + 1;
    }

    static String searchBST(TreeNode root, int val) {
        searchPattern += root.nodeType == "success" ? root.val + " " : "F ";
        if (root.nodeType == "success") {
            if (root.val == val) {
                comparision++;
                return "FOUND";
            } else if (root.val >= val) {
                comparision = comparision + 2;
                return searchBST(root.left, val);
            } else {
                comparision = comparision + 2;
                return searchBST(root.right, val);
            }
        }
        return "NOT FOUND";
    }

    static TreeNode createBST(int arr[], int l, int h) {
        if (l > h) {
            return null;
        }

        int mid = (l + h) / 2;
        TreeNode node = generateNode(arr[mid], "success");
        node.left = createBST(arr, l, mid - 1);
        node.right = createBST(arr, mid + 1, h);

        return node;
    }

    static TreeNode createDecisionTree(int arr[], int l, int h) {
        if (l > h) {
            return null;
        }

        int mid = (l + h) / 2;
        TreeNode node = generateNode(arr[mid], "success");
        node.left = createDecisionTree(arr, l, mid - 1);
        node.right = createDecisionTree(arr, mid + 1, h);

        if (node.left == null) {
            node.left = generateNode(-1, "failure");
        }
        if (node.right == null) {
            node.right = generateNode(-1, "failure");
        }

        return node;
    }

    static TreeNode generateNode(int val, String type) {
        TreeNode tree = new TreeNode(val, type);
        return tree;
    }

}
