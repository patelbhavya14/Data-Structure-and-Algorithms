/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4info6205;

/**
 *
 * @author bhaVYa
 */
public class TreeTraversal {
    static int totalNode = 0;

    void inorderTraversal(TreeNode treeNode) {
        totalNode++;
        if(treeNode == null) {
            totalNode--;
            return;
        }
        inorderTraversal(treeNode.left);
        System.out.print(treeNode.nodeType == "success"?treeNode.val+" ": "");
        inorderTraversal(treeNode.right);
    }

    void preorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        System.out.print(treeNode.nodeType == "success"?treeNode.val+" ": "");
        preorderTraversal(treeNode.left);
        preorderTraversal(treeNode.right);
    }

    void postorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        postorderTraversal(treeNode.left);
        postorderTraversal(treeNode.right);
        System.out.print(treeNode.nodeType == "success"?treeNode.val+" ": "");
    }
}
