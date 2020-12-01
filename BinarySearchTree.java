// File Name: BinarySearchTree.java
// Author: Faith Reeves
// Program Purpose: a BST tree class that will store nodes for organizing
//                  storing, and traversing intensity values and data

package imageenhancement;

public class BinarySearchTree {
    
    // declare the BST root
    private BSTNode root;
    
    // declare and initialize a count variable to 0
    int count = 0;
    
    // no arg constructor
    public BinarySearchTree() {
        
        // set the root to null
        root = null;
    }
    
    // method to check if the tree is empty
    public boolean isEmpty() {
        
        // return a boolean, true if empty
        return root == null;
    }
    
    // method to create a new BST node
    public void insert(int data) {
        
        // call the private insert method with root and data
        root = insert(root, data);
    }
    
    // method to insert data recursively into the tree
    private BSTNode insert(BSTNode node, int data) {
        
        // if the node is null, create a new node
        if (node == null) {
            
            // create new BSTNode node
            node = new BSTNode(data);
        }
        
        // if the node is not null, execute
        else {
            
            // if the data < parent, traverse left
            if (data < node.getData()) {
                
                // call the insert method on the left node
                node.left = insert(node.left, data);  
            }
            
            // if data > parent, traverse right
            else if (data > node.getData()) {
                
                // call the insert method on the right node
                node.right = insert(node.right, data);
            }
            
            // if the data == parent, increment intensity count
            else {
                
                // call method to increment the node's intensity count
                node.incrementIntensityCount();
            }
        }
        
        // return the node
        return node;
    }
    
    // method to count number of nodes in BST
    public int countNodes() {
        
        // call the private countNodes method with root
        return countNodes(root);
    }
    
    // method to count the number of nodes recursively
    private int countNodes(BSTNode r) {
        
        // if the node is null, return 0
        if (r == null) {
            
            return 0;
        }
        
        // if node is NOT null, execute
        else {
            
            // initialize count to 1
            int countN = 1;
            
            // increment count for each child node
            countN += countNodes(r.getLeft());
            countN += countNodes(r.getRight());
            
            // return the count
            return countN;
        }
    }
    
    // method to search for an element
    public boolean search(int val) {
        
        // call the private search method with root and value to be searched for
        return search(root, val);
    }
    
    // method to search for an element recursively
    private boolean search(BSTNode node, int val) {
        
        // declare the default found value to false
        boolean found = false;
        
        // cycle through loop while node is not null and hasn't been found
        while ((node != null) && !found) {
            
            // store the node's value
            int nodeVal = node.getData();
            
            // if the node's value is < current value, go left
            if (val < nodeVal) {
                
                // set the node to be the left child
                node = node.getLeft();
            }
            
            // if the node's value is > current value, go right
            else if (val > nodeVal) {
                
                // set the node to be the right child
                node = node.getRight();
            }
            
            // if the values are equal, return found
            else {
                
                // set found to true
                found = true;
                
                // print out the value for the new pixel intensity
                System.out.printf("%-3d", node.getNewIntensityValue());
                
                // break out of while loop
                break;
            }
            
            // call the function again with the new mode
            found = search(node, val);
        }
        
        // return the boolean result
        return found;
    }
    
    // method for inOrder traversal
    public void inOrder() {
        
        // call the private inOrder method with the root
        inOrder(root);
    }
    
    // method for recursive inOrder traversal
    private void inOrder(BSTNode node) {
        
        // if the node is NOT null, execute the if statement
        if (node != null) {
            
            // go to the left node
            inOrder(node.getLeft());
            
            // visit the node (increment the less than or equal counter)
            node.incrementLessThan();
            
            // go to the right node
            inOrder(node.getRight());
        }
    }
    
    // method for height of BST
    public int height(){
        
        // call the recursive method with the root
        return height(root);
    }
    
    // method to return height of BST recursively
    private int height(BSTNode root) {
        
        // if the root is null, return 0
        if (null == root) {
            
            return 0;
        }
        
        // find the height of the left subtree
        int heightLeftSub = height(root.left);
        
        // find the height of the right subtree
        int heightRightSub = height(root.right);
        
        // return the greatest subtree value plus 1 for the height
        return Math.max(heightLeftSub, heightRightSub) + 1;  
    }
    
    // method for calculating a node's new intensity value using inOrder traversal
    public void calculateNewIntensity() {
        
        // call the recursive method with the root
        calculateNewIntensity(root);
    }
    
    // method for recursive inOrder traversal
    private void calculateNewIntensity(BSTNode node) {
        
        // if the node is NOT null, execute if statement
        if (node != null) {
            
            // call method on left node
            calculateNewIntensity(node.getLeft());
            
            // visit the node (calculate and assign new intensity value)
            node.newIntensity(node);
            
            // call method on right node
            calculateNewIntensity(node.getRight());
        }
    }
    
   // method to count the number of pixels in a given range
    public int rangeCount(int min, int max) {
        
        // call the recursive method with the root and min and max values
        int answer = rangeCount(root, min, max);
        
        // return the final count
        return answer;
    }
    
    // method to count number of pixels in a given range using inOrder traversal
    private int rangeCount(BSTNode node, int min, int max) {
        
        // if the node is NOT null, execute statement
        if (node != null) {
            
            // call the method on the left child
            rangeCount(node.getLeft(), min, max);
            
            // visit the node (increment the counter by the number of pixels found)
            count += node.pixelCount(node, min, max);
               
            // call the method on the right child
            rangeCount(node.getRight(), min, max);
        }
            // return the count
            return count;
    }
    
    // method to set the count variable to 0
    public void setCountToZero() {
        
        // set count to 0
        count = 0;
    }  
}
