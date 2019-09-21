package tree;

public class TreeTraversal {
    static int totalNode = 0;

    void inorderTraversal(TreeNode treeNode) {
        totalNode++;
        if(treeNode == null) {
            totalNode--;
            return;
        }
        inorderTraversal(treeNode.left);
        System.out.print(treeNode.val+" ");
        inorderTraversal(treeNode.right);
    }

    void preorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        System.out.print(treeNode.val +" ");
        preorderTraversal(treeNode.left);
        preorderTraversal(treeNode.right);
    }

    void postorderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        postorderTraversal(treeNode.left);
        postorderTraversal(treeNode.right);
        System.out.print(treeNode.val +" ");
    }
}
