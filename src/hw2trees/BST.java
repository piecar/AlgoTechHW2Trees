
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
    private String leafString;
    private String subtreeString;
    private TTraversal traversal;
    private String displayTree;
    private String travString;
    
    // Constructors
    public BST()
    {
        root = null;
        traversal = new TTraversal(root);
        nodeNum = 0;
        leafString = "";
        travString = "";
        subtreeString = "{}";
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
     * isChild method that returns a string
     * @param parent
     * @param child
     * @return 
     */
    public String isChild(int parent, int child)
    {
        if((getNode(root, parent) == null) || (getNode(root,child) == null)) return "";
        if(isAChild(parent, child))
            return child +" is a child of" +parent;
        else
            return child +" is not a child of" +parent;
    }
    
    /**
     * Finds if the second given value is a child of the parent.
     * Run time (log n)^2, because inTree takes log n time and so does getNode.
     * @param parent
     * @param child
     * @return 
     */
    public boolean isAChild(int parent, int child)
    {
        if (inTree(root, parent))
        {
            TreeNode parentN = getNode(root, parent);
            return (parentN.left().element() == child ||
                    parentN.right().element() == child);
        }
        else
            return false;
    }
    
    /**
     * isParent method that returns a string.
     * @param parent
     * @param child
     * @return 
     */
    public String isParent(int parent, int child)
    {
        if((getNode(root, parent) == null) || (getNode(root,child) == null)) return "";
        if(isAParent(parent, child))
            return parent +" is a parent of " +child;
        else
            return parent +" is not a parent of " +child;
    }
    
    /**
     * Finds if the first value inputted is the parent of the second value
     * inputted.
     * Run time (log n)^2, because inTree is log n and so is getNode.
     * @param parent
     * @param child
     * @return 
     */
    public boolean isAParent(int parent, int child)
    {
        if (inTree(root, child) && child != root.element())
        {
            TreeNode childN = getNode(root, child);
            TreeNode parentN = getNode(root, parent);
            return isAChild(parentN.element(), childN.element());            
        }
        else
            return false;
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
    
    /**
     * Public method for inTree
     * @param num
     * @return 
     */
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
    
    /**
     * Public method to return the minimum of the tree
     * @return 
     */
    public String getMin()
    {
        TreeNode temp = getMin(root);
        int tempMin = temp.element();
        return "" + tempMin;
    }
    
    /**
     * Finds the minimum value given a tree.
     * Run time log n, because you ignore one half of the tree every iteration.
     * @param rt
     * @return 
     */
    private TreeNode getMin(TreeNode rt)
    {
        if (rt.left() == null)
            return rt;
        else
            return getMin(rt.left());
    }   
    
    /**
     * Method to find the tree height.
     * Worst case run time n, because you have to look at the level of every node
     * and find the max.
     * @return 
     */
    public int TreeHeight()
    {
        int temp = MaxDepth(root);
        return temp +1;
    }
    
    /**
     * Finds the Maximum depth of a tree
     * Worst case run time n, because you must find the level of every node.
     * @param rt
     * @return 
     */
    private int MaxDepth(TreeNode rt)
    {
        if (rt == null)
            return  -1;
        int leftHeight = MaxDepth(rt.left());
        int rightHeight = MaxDepth(rt.right());
        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;                    
    }
    
    /**
     * Public method to find the level of a node given a value.
     * Worst case run time log n, because you're searching for an element.
     * @param num
     * @return 
     */
    public int findLevel(int num)
    {
        return findLevel(root, num, 0);
    }
    
    /**
     * Finds a level given a tree, a value and the level of the node of the
     * given tree.
     * @param rt
     * @param num
     * @param level
     * @return 
     */
    private int findLevel(TreeNode rt, int num, int level)
    {
        if (rt == null)
            return Integer.MAX_VALUE;
        if(rt.element() > num)
        {
            level++;
            return findLevel(rt.left(), num, level);
        }
        if(rt.element() < num)
        {
            level++;
            return findLevel(rt.right(), num, level);
        }
        else
        {
            return level;
        }
    }
    
    /**
     * Public method to find if a tree is balanced, returns a string saying if
     * it is balanced or unbalanced.
     * @return 
     */
    public String isBalanced()
    {
        if (isBalanced(root))
            return "The tree is balanced.";
        else
            return "The tree is not balanced.";
    }
    
    /**
     * Finds if a tree is balanced or unbalanced. If balanced it returns as
     * true, false if unblanaced.
     * @param rt
     * @return 
     */
    private boolean isBalanced(TreeNode rt)
    {
        if (rt == null)
            return true;
        return Math.abs(MaxDepth(rt.left()) - MaxDepth(rt.right())) <= 1;
    }
    
    /**
     * Public method to find if given tree is actually a tree.
     * @return 
     */
    public String isTree()
    {
        if (isTree(root, getMin(root).element(), getMax(root).element()))
            return "It's a binary search tree";
        else
            return "It's not a binary search tree";            
    }
    
    /**
     * Finds if a given object is a binary search tree given a root and 
     * the min, max values of the tree.
     * @param rt
     * @param min
     * @param max
     * @return 
     */
    private boolean isTree(TreeNode rt, int min, int max)
    {
        if (rt == null)
            return true;
        return rt.element() >= min
                &&rt.element() <= max
                &&isTree(rt.left(), min, Math.min(rt.element(), max))
                &&isTree(rt.right(), Math.max(rt.element(), min), max);

    }    
    
    /**
     * Given a value finds the path to the node. If value does not exist an 
     * error message appears, if it does exist the path is returned.
     * @param key
     * @return 
     */
    public String pathToNode(int key)
    {
        String path = "";
        if (root == null)
            return "This tree is empty.";
        if (inTree(root, key))
            return pathToNode(root, key, path);
        else
            return null;        
    }
    
    /**
     * Finds the path to the node given a tree, the value to search for and 
     * an initial path.
     * @param rt
     * @param key
     * @param path
     * @return 
     */
    private String pathToNode (TreeNode rt, int key, String path)
    {
        if (rt.element() > key)
        {
            path = path + " " + rt.element();
            return pathToNode(rt.left(), key, path);
        }
        else if (rt.element() < key)
        {
            path = path + " " + rt.element();
            return pathToNode(rt.right(), key, path);
        }
        else
            path = path + " " + rt.element();
        return path;
    }
    
    public String findLeaves()
    {
        leafString = "";
        findLeaves(root);
        return leafString;
    }
    
    private void findLeaves(TreeNode rt)
    {
        if (rt == null) return;
        if(!rt.isLeaf())
            findLeaves(rt.left());
        if(rt.isLeaf())
            leafString = leafString + rt.element() +" ";
        if(!rt.isLeaf())
            findLeaves(rt.right());
    }
    
    public String findSubtrees()
    {
        String emptySubset = "{} ";
        if (root == null)
            return "The subtrees of the tree are: " + emptySubset;
        else
        {
            findSubtrees(root);
            return "The subtrees of the tree are: {" + subtreeString +"}";             
        }
    }
    private void findSubtrees(TreeNode rt)
    {
        if (rt == null) return;
        findSubtrees(rt.left());
        findSubtrees(rt.right());
        subtreeString += ", " + rt.element() + " ";    
    }
    
//    public void printGivenLevel(TreeNode root, int level)
//    {
//        if(root == null)
//            return;
//        if(level == 1)
//            rtElement += root.element();
//        else if (level > 1)
//        {
//            printGivenLevel(root.left(), level-1);
//            printGivenLevel(root.right(), level-1);
//        }
//    }
    
//    public void displayTree()
//    {
//        displayTree(root, "");
//    }
    
//    public String displayTree()
//    {
//        String s = print();
//        String[] strArray = s.split(" ");
////        System.out.println(strArray[0]);
//        int j = 0;
//        int k = 0;
//        for(int i = 0; i < strArray.length; i++)
//        {
//            
//            j = findLevel(Integer.parseInt(strArray[i])); //5 7 3 9 1 8 4
//            
//            if(j == k)
//            {
//                displayTree += strArray[i] + "\t";
//            }
//            if(j != k)
//            {
//                displayTree += "\n\t";
//                k++;
//            }
//        }
//        return displayTree;
        
        
//        for(int k = 0; k < j; k++)
//        {
//            printG
//        }
//    }
}

