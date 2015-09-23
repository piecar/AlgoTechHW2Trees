
package hw2trees;

/**
 * Represents any Node in a tree. Has an element, and two children nodes.
 * @author Pierre Jimenez
 */
public class TreeNode
{
    // Variables
    private int element;
    private TreeNode left;
    private TreeNode right;
    
    // Constructors
    public TreeNode(int element)
    {
        this.left = this.right = null;
        this.element = element;
    }
    
    public TreeNode(int element, TreeNode left, TreeNode right)
    {
        this.left = left;
        this.right = right;
        this.element = element;
    }
    
    // Accessor Methods
    public int element()
    {
        return element;
    }
    
    public TreeNode left()
    {
        return left;
    }
    
    public TreeNode right()
    {
        return right;
    }
    
    // Mutator Methods
    public void setElement(int element)
    {
         this.element = element;
    }
    
    public void setLeft(TreeNode left)
    {
        this.left = left;
    }
    
    public void setRight(TreeNode right)
    {
        this.right = right;
    }
    
    public Boolean isLeaf()
    {
        return (right == null) && (left == null);
    }
    
}
