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
public class TreeNode {
    int val;
    String nodeType;
    TreeNode left, right;

    TreeNode(int val, String type) {
        this.val = val;
        this.nodeType = type;
        left = right = null;
    }
}
