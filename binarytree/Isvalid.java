package binarytree;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}


public class Isvalid {

    public boolean isvalidBST(TreeNode root){
        return isvalidBSTHealper(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
    
    private boolean isvalidBSTHealper(TreeNode root, Long min, long maxValue) {
       
        if(root == null){
            return true;
        }

        if(root.data <= min || root.data >= maxValue)  return false;

        if(isvalidBSTHealper(root.left, min, root.data) && isvalidBSTHealper(root.right, (long) root.data, maxValue)){
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        
    }
}
