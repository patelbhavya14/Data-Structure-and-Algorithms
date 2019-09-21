package tree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BST {
    static TreeNode root = null;
    public static void main(String[] args) {
        //int arr[] = {3,6,7,10,12,15,18,20};
        int arr[] = {11,12,20,22,25,26,27,30};
//        for(int i: arr) {
//            root = insertNode(root, i);
//        }

        root = createBST(arr, 0, arr.length-1);
        TreeTraversal traversal = new TreeTraversal();

        System.out.print("Inorder traversal: ");
        traversal.inorderTraversal(root);
        System.out.println();

        System.out.println(searchBST(root, 27));
        //System.out.println("Height of decision tree: "+Math.ceil(Math.log(traversal.totalNode)));

        traversal.inorderTraversal(deleteNode(root, 27));
    }

    // Searching node in BST
    static String searchBST(TreeNode root, int val) {
        if(root == null) {
            return "NOT FOUND";
        }
        if(root.val == val) {
            return "FOUND";
        } else if(root.val >= val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    // Create BST from array
    static TreeNode createBST(int arr[], int l, int h) {
        if(l>h) {
            return null;
        }
        int mid = (l+h)/2;
        TreeNode node = generateNode(arr[mid]);
        node.left = createBST(arr, l, mid-1);
        node.right = createBST(arr, mid+1, h);
        return node;
    }

    // Delete node from BST
    static TreeNode deleteNode(TreeNode root, int val) {
        TreeNode x = root, p = null;

        // Search and exception
        while(x != null) {
            if(val == x.val) {
                break;
            }
            p = x;
            x = val < root.val? x.left: x.right;
        }
        if(x == null) {
            throw new IllegalArgumentException();
        }

        // x has 2 children
        if(x.left != null && x.right != null) {
            TreeNode y = x.left;
            p = x;
            while(y.right != null) {
                p = y;
                y = y.right;
            }
            x.val = y.val;
            x = y;
        }

        // leaf and 1 child case
        if(p == null) {
            return x.left != null? x.left: x.right;
        }
        TreeNode temp = x.left != null? x.left: x.right;
        if(x == p.right)
            p.right = temp;
        else
            p.left = temp;
        return root;
    }

    // Inserting node in BST
    static TreeNode insertNode(TreeNode root, int val) {
        if(root == null) {
            root = generateNode(val);
        }
        else if(val <= root.val) {
            root.left = insertNode(root.left, val);
        }
        else {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    // Generating node for BST
    static TreeNode generateNode(int val) {
        TreeNode tree = new TreeNode(val);
        return tree;
    }

}
