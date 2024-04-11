package binarytree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

   
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class BinarySearchTree {
    private TreeNode root; 

    
    public BinarySearchTree() {
        this.root = null;
    }

    
    public void insert(int val) {
        this.root = insertRecursive(this.root, val);
    }

   
    private TreeNode insertRecursive(TreeNode root, int val) {
       
        if (root == null) {
            return new TreeNode(val);
        }

       
        if (val < root.val) {
            root.left = insertRecursive(root.left, val);
        } else if (val > root.val) {
            root.right = insertRecursive(root.right, val);
        }

        
        return root;
    }

   
    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderRecursive(this.root);
        System.out.println(); 
    }

    
    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }

    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(12);

        
        bst.inorderTraversal();
        
    }
}
