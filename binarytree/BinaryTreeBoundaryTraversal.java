package binarytree;
import  java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}



public class BinaryTreeBoundaryTraversal {

   
    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> boundaryNodes = new ArrayList<>();
        if (root == null) {
            return boundaryNodes;
        }

        boundaryNodes.add(root.val);

        
        addLeftBoundary(root.left, boundaryNodes);

        
        addLeaves(root, boundaryNodes);

        
        addRightBoundary(root.right, boundaryNodes);

        return boundaryNodes;
    }

   
    private static void addLeftBoundary(TreeNode node, List<Integer> boundaryNodes) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        boundaryNodes.add(node.val);
        if (node.left != null) {
            addLeftBoundary(node.left, boundaryNodes);
        } else {
            addLeftBoundary(node.right, boundaryNodes);
        }
    }

    
    private static void addLeaves(TreeNode node, List<Integer> boundaryNodes) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            boundaryNodes.add(node.val);
        }
        addLeaves(node.left, boundaryNodes);
        addLeaves(node.right, boundaryNodes);
    }

    
    private static void addRightBoundary(TreeNode node, List<Integer> boundaryNodes) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        if (node.right != null) {
            addRightBoundary(node.right, boundaryNodes);
        } else {
            addRightBoundary(node.left, boundaryNodes);
        }
        boundaryNodes.add(node.val);
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        // Perform boundary traversal
        List<Integer> result = boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + result); 
  
    }
}
