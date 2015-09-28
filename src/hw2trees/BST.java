
package hw2trees;


/**
 * Binary Search Tree that only accepts int's as element values.
 * @author Eric Aguilar, Eduardo Guerra, Pierre Jimenez, Ricardo Viera
 */
public class BST
{
    // Variables
    private TreeNode root;
    private int nodeNum;
    private String travString;
    
    // Constructors
    public BST()
    {
        root = null;
        nodeNum = 0;
        travString = "";
    }
    
    /**
     * Public Insert method
     * Run time log n because it ignores one half of the tree every recursion.
     * @param num 
     */
    public void insert(int num)
    {
        root = insert(root, num);
        if (root != null)
            nodeNum++;
    }
    
    /**
     * Private Insert method that "knows" the root of the BST
     * Run time log n because it ignores one half of the tree every recursion.
     * @param rt
     * @param num
     * @return 
     */
    private TreeNode insert(TreeNode rt, int num)
    {
        if (rt == null)
            return new TreeNode(num);
        if (rt.element() > num )
            rt.setLeft(insert(rt.left(), num));
        else if (rt.element() < num )
            rt.setRight(insert(rt.right(), num));
        else
            return null;
        return rt;
    }
    
    /**
     * Return the String representation of the tree from the root.
     * Run time n, because you have to look at every element.
     * @return 
     */
    public String inorder()
    {
        travString = "";
        inorder(root);
        return travString;
    }
    
    /**
     * Return the string representation of the tree from any given node.
     * Run time n, because you have to look at every element.
     * @param rt 
     */
    public void inorder(TreeNode rt)
    {
        if (rt == null) return;
        inorder(rt.left());
        travString += rt.element() +" ";
        inorder(rt.right());
    }
    
    /**
     * The accessor method for the inorder string representation of the tree.
     * Run time n, because you have to look at every element.
     * @return 
     */
    public String print()
    {
        return inorder();
    }
    
    /**
     * The accessor method for the int of how many nodes are in the tree.
     * Run time constant, it just returns a variable.
     * @return 
     */
    public int numOfNodes()
    {
        return nodeNum;
    }
    
    public TreeNode getRoot()
    {
        return root;
    }
    
    /**
     * Returns the node of a tree given a value. Should only be used in
     * conjuction with inTree method.
     * Run time log n, because you ignore one half of the tree
     * @param rt
     * @param num
     * @return 
     */
    private TreeNode getNode(TreeNode rt, int num)
    {
        if (rt == null) 
            return null;
        if (rt.element() > num)
            return getNode(rt.left(), num);
        else if (rt.element() < num)
            return getNode(rt.right(), num);
        else
            return rt;         
    }
    
    public boolean inTree(int num)
    {
        return inTree(root, num);
    }
    /**
     * Checks to see if key in tree. If in tree: true, if not in tree: false.
     * Run time log n, because you ignore one half of the tree every iteration.
     * @param rt
     * @param num
     * @return 
     */
    private boolean inTree(TreeNode rt, int num)
    {
        if (rt == null)
            return false;
        if (rt.element() > num)
            return inTree(rt.left(), num); 
        else if (rt.element() < num)
            return inTree(rt.right(), num);
        else
            return true;    
    }
    
    /**
     * Deletes a node from the tree given a value and returns the string
     * representation.
     * Run time (log n)^2, because InTree is log n and so is DeleteNode. 
     * @param num
     * @return 
     */
    public String delete(int num)
    {
        boolean exists = inTree(root, num);
        if (exists)
        {
            TreeNode temp = deleteNode(root, num);
            nodeNum--;
            return String.valueOf(temp.element());
        }
        else
            return "null";        
    }
    
    /**
     * Deletes the maximum value from a tree
     * Run time log n, because you ignore one half of the tree every iteration.
     * @param rt
     * @return 
     */
    private TreeNode deleteMax(TreeNode rt)
    {
        if (rt.right() == null)
            return rt.left();
        rt.setRight(deleteMax(rt.right()));
        return rt;        
    }   
        
    /**
     * Given a tree and the value to be deleted it deletes the value and 
     * returns the node that was deleted.
     * Worst case running time (log n)^2, because the tree iteration is log n, and so is GetMax.
     * @param rt
     * @param num
     * @return 
     */
    private TreeNode deleteNode(TreeNode rt, int num)
    {
        if (rt == null)
            return null;
        if (rt.element() > num)
            rt.setLeft(deleteNode(rt.left(), num));
        else if (rt.element() < num)
            rt.setRight(deleteNode(rt.right(), num));
        else
        {
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
                return rt.left();
            else
            {
                TreeNode temp = getMax(rt.left());
                rt.setElement(temp.element());
                rt.setLeft(deleteMax(rt.left()));
            }       
        }
        return rt;   
    }
    /**
     * Public method to return the maximum of the tree
     * @return 
     */
    public String getMax()
    {
        TreeNode temp = getMax(root);
        int tempMax = temp.element();
        return "" + tempMax;
    }
    
    /**
     * Finds the maximum value given a tree.
     * Run time log n, because you ignore one half of the tree every iteration.
     * @param rt
     * @return 
     */
    private TreeNode getMax(TreeNode rt)
    {
        if (rt.right() == null)
            return rt;
        else
            return getMax(rt.right());
    }
    
}

