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
public class HW2Trees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST myTree = new BST();
        
        myTree.insert(50);
        myTree.insert(2);
        myTree.insert(17);
        myTree.insert(33);
        myTree.insert(69);
        myTree.insert(65);
        myTree.insert(73);
        myTree.insert(52);
        myTree.insert(25);
        myTree.insert(1);
        myTree.insert(8);
        myTree.insert(99);
        myTree.insert(44);
        myTree.insert(42);
        myTree.insert(6);        
        myTree.insert(100);
        myTree.insert(23);
        System.out.println("The Tree has elements: " + myTree.print());
        myTree.delete(42);
        myTree.delete(17);
        System.out.println("The Tree has elements: " + myTree.print());
        myTree.insert(59);
        System.out.println("The Tree has elements: " + myTree.print());
        System.out.println("The Tree has element 6: " + myTree.inTree(6));
        System.out.println("The Tree has element 55: " + myTree.inTree(55));
    }
    
}
