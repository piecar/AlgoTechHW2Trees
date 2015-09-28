/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2trees;

/**
 *
 * @author piecar
 */
 

public class Node{
    int val;
    Node left;
    Node right;
    Node(int x) {val = x;}
}

/**
 * Assumption: Node a and b are elements within the tree.
 * @author piecar
 */
public class Solution {
    public Node DCA(Node root, Node a, Node b)
    {
        if(root.val == a.val || root.val == b.val)// if one/both equal to root..
        {
            return root; //.. that is the deepest common ancestor
        }
        else if(root.val < a.val && root.val < b.val) // if both bigger.,
        {
            return DCA(root.right, a, b); //.. find DCA in the right subtree
        }
        else if(root.val > a.val && root.val > b.val) // if both smaller.,
        {
            return DCA(root.left, a, b); //.. find DCA in the left subtree
        }
        else // if one bigger than root, and other smaller...
        {
            return root; // .. That is the deepest common ancestor
        }
    }
}
        
    
    

