
package hw2trees;

/**
 * Class that can traverse a tree given a node.
 * @author Eric Aguilar, Eduardo Guerra, Pierre Jimenez, Ricardo Viera
 */
public class TTraversal {
    //Variables
    String preString;
    String postString;
    String inString;
    TreeNode root;
    
    public TTraversal(TreeNode root)
    {
        this.inString = "";
        this.postString = "";
        this.preString = "";
        this.root = root;
    }
    
    /**
     * Changes the root node.
     * @param rt 
     */
    public void setRoot(TreeNode rt)
    {
        root = rt;
    }            
    
     /**
     * Public method for inorder traversal.
     */
    public void inorder()
    {
        inString = "";
        inorder(root);
    }
    
    /**
     * Adds to the string variable the inorderd tree.
     * @param rt 
     */
    public void inorder(TreeNode rt)
    {
        if (rt == null) return;
        inorder(rt.left());
        inString += rt.element() +" ";
        inorder(rt.right());
    }
    
    /**
     * Public method for preorder traversal.
     */
    public void preorder()
    {
        preString = "";
        preorder(root);
    }
    
    /**
     * Adds to the string variable the preorderd tree.
     * @param rt 
     */        
    public void preorder(TreeNode rt)
    {
        if (rt == null) return;
        preString += rt.element() +" ";
        preorder(rt.left());
        preorder(rt.right());
    }
    
    /**
     * public method for postorder
     */
    public void postorder()
    {
        postString = "";
        postorder(root);
    }
    
    /**
     * Adds to the string variable the postordred tree.
     * @param rt 
     */
    public void postorder(TreeNode rt)
    {
        if (rt == null) return;
        postorder(rt.left());
        postorder(rt.right());
        postString += rt.element() +" ";
    } 
    
    public String getInorder()
    {
        return inString;
    }
    
    public String getPostorder()
    {
        return postString;
    }
    
    public String getPreorder()
    {
        return preString;
    }
    
}
