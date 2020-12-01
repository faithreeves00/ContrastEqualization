// File Name: BSTNode.java
// Author: Faith Reeves
// Program Purpose: a BST Node class for creating nodes for a BST. Nodes store
//                  intensity values, a count of equal or less than AND equal 
//                  values, and new intensity values

package imageenhancement;

public class BSTNode {
    
    // declare left and right nodes
    BSTNode left, right;
    
    // declare datafields for intensity values, count of intensity values,
    // count of intensity values <= data, and new intensity value
    int data, intensityCount, lessThanOrEqual, newIntensityValue;
    
    // declare static counter for "less than or equal" 
    static int count = 0;
    
    // no arg constructor
    public BSTNode() {
        
        // set data fields to default values
        left = null;
        right = null;
        data = 0;
        intensityCount = 0;
        lessThanOrEqual = 0;
        newIntensityValue = 0;
    }
    
    // constructor that sets the node's key data value (intensity value)
    public BSTNode(int n) {
        
        // set all data fileds to default values except set data to n
        left = null;
        right = null;
        data = n;
        intensityCount = 1;
        lessThanOrEqual = 0;
        newIntensityValue = 0;
    }
    
    // method to set left node 
    public void setLeft(BSTNode n) {
        
        // set left to the given node
        left = n;
    }
    
    // method to set right node
    public void setRight(BSTNode n) {
        
        // set right to the given node
        right = n;
    }
    
    // method to get left node
    public BSTNode getLeft() {
        
        // return the left node
        return left;
    }
    
    // method to get right node
    public BSTNode getRight() {
        
        // return the right node
        return right;
    }
    
    // method to set a node's data
    public void setData(int d) {
        
        // set data to the given integer
        data = d;
    }
    
    // method to get the data from a node
    public int getData() {
        
        // return the node's data
        return data;
    }
    
    // method to get a node's intensity count
    public int getIntensity(){
        
        // return the intensity count
        return intensityCount;
    }
    
    // method to get a node's count for "less than or equal"
    public int getLessThan() {
        
        // return the node's count for lessThanOrEqual
        return lessThanOrEqual;
    }
    
    // method to increment the nodes counter for intensity values
    public void incrementIntensityCount() {
        
        // increment the counter variable
        intensityCount++;
    }
    
    // method to add the intensityCount to the lessThanOrEqual
    public void incrementLessThan() {
        
        // add the intensity count to the counter variable
        count += intensityCount;
        
        // add the count to the lessThanOfEqual variable
        lessThanOrEqual += count;
    }
    
    // method to calculate and assign the node's new intensity value
    public void newIntensity(BSTNode node) {
        
        // use the given equation to calculate the node's new intensity
        double temp = Math.round(((double)node.getLessThan() / count) * 255);
        
        // assign the new intensity to the node
        newIntensityValue = (int)temp;
    }  
    
    // method to get a node's new intensity value
    public int getNewIntensityValue() {
        
        // return the new intensity value
        return newIntensityValue;
    }
    
    // method to count the number of pixels in a given range
    public int pixelCount(BSTNode node, int min, int max) {
        
        // intialize the count to 0
        int countP = 0;
        
        // loop through for each value in the range (16 times)
        for (int i = min; i <= max; i++) {
            
            // if the node's new intensity value matches the number from the range,
            // execute if statement
            if(node.getNewIntensityValue() == i) {
                
                // add the amount of times that value appears to the count variable
                countP += node.getIntensity();   
            }
        }
        
        // return the count
        return countP; 
    }
}
