package binarytree;

class TreeNode{
    int val ;
    TreeNode right;
    TreeNode left;

    TreeNode(int data){
        this.val = data;
        this.right = null;
        this.left = null;
    }
}
public class Mirror {


    public static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true; // An empty tree is symmetric
        }

        return ismirror(root.left , root.right);

    }

    private static boolean ismirror(TreeNode node1, TreeNode node2) {
        if(node1 == null && node1 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }


        return (node1.val  == node2.val) && ismirror(node1.left, node2.right) && ismirror(node1.right, node2.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        boolean symmetric = isSymmetric(root);

        if(symmetric){
            System.out.println("Tress is mirror");
        }else{
            System.out.println("Tree is not mirror");
        }

    }
}
