
public class MirrorBinaryTree {

	public TreeNode invertTree(TreeNode root) {
        if(root==null || root.left==null||root.right==null){
       return root;
       }
        
       TreeNode temp=root.right;
       root.right=root.left;
       root.left=temp;
       invertTree(root.left);
       invertTree(root.right);    
       return root;
   }
}
