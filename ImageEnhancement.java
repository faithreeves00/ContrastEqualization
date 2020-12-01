// File Name: ImageEnhancement.java
// Author: Faith Reeves
// Program Purpose: to improve the quality of an image by spreading the number 
//                  of pixels across a range of intensity values and utilizing
//                  a binary search tree

package imageenhancement;

import java.util.*;

public class ImageEnhancement {

    public static void main(String[] args) {

        // declare variables for number of row, number of columns
        int rows, columns;

        // create a BST object
        BinarySearchTree BST = new BinarySearchTree();

        // create a Scanner object
        Scanner input = new Scanner(System.in);

        // prompt the user for the number of rows and columns in their grid
        System.out.print("Enter the number of rows and number of columns"
                + " for your source image separated by a space: ");

        // beginning of try block   
        try {
            // read in the users row answer
            rows = input.nextInt();

            // if the user input for rows is not 1-2000, execute
            if (rows > 2000 || 0 >= rows) {

                // display error message
                System.out.println("Entry for row number must be from 1-2000. Exiting"
                        + " program.");

                // exit program
                System.exit(1);
            }

            // read in the users column answer
            columns = input.nextInt();

            // if the user input for columns is not 1-2000, execute
            if (columns > 2000 || 0 >= columns) {

                // display error message
                System.out.println("Entry for column number must be from 1-2000. Exiting"
                        + " program.");

                // exit program
                System.exit(2);
            }

            // declare an array list to store the pixel intensities 
            List<Integer> list = new ArrayList<>();

            // interate through the for loop according to the number of rows given
            for (int i = 0; i < rows; i++) {

                // prompt user to enter a row of pixel intensity values
                System.out.print("Enter " + columns + " pixel intensity values "
                        + "(from 0-255) with spaces in between: ");

                // read in and store each value in the BST
                for (int j = 0; j < columns; j++) {

                    // store each pixel intensity in this variable
                    int userInput = input.nextInt();

                    // if the user input for a pixel intenisty is not 0-255, execute
                    if (userInput > 255 || userInput < 0) {

                        // display error message
                        System.out.println("Entry for pixel intensity must be from "
                                + "0-255. Exiting Program.");

                        // exit program 
                        System.exit(3);
                    }

                    // insert each pixel intensity into the BST
                    BST.insert(userInput);

                    // add the pixel intensity to the array list
                    list.add(userInput);
                }
            }

            // output the BST height
            System.out.println("Height: " + BST.height());

            // output the number of nodes in the BST
            System.out.println("Number of Nodes: " + BST.countNodes());

            // tell the user that you are outputting an intensity histogram
            System.out.println("INTENSITY HISTOGRAM");

            // display headers
            System.out.println(String.format("%-15s%-15s%s", "Intensity", "Pixel", "Markers"));

            System.out.println(String.format("%-15s%-15s", "Range", "Count"));

            // perform an inOrder traversal to count the number of pixels with
            // intensities less than or equal to that node's pixel intensity
            BST.inOrder();

            // perform an inOrder traversal and calculate and assign new intensity values
            BST.calculateNewIntensity();

            // start the minimum range at 0
            int rangeMin = 0;

            // start the max range at 15
            int rangeMax = 15;

            // output 16 rows of histogram data
            for (int i = 0; i < 16; i++) {

                // store the intensity range in a string
                String range = rangeMin + "-" + rangeMax;

                // display the intensity range
                System.out.printf("%-15s", range);

                // store the number of pixels in that range in a variable
                int pixelCount = BST.rangeCount(rangeMin, rangeMax);

                // display the pixel count
                System.out.printf("%-15d", pixelCount);

                // create an empty string for the markers
                String markers = "";

                // calculate number of markers needed for pixel range
                int numMarkers = (int) Math.ceil((pixelCount / 20.0));

                // add an * the the markers variable for each 20 pixels (ceiling)      
                for (int j = 0; j < numMarkers; j++) {

                    // add an *
                    markers += "*";
                }

                // display the markers for that row
                System.out.printf("%-15s\n", markers);

                // reset the counter for pixels in that range to 0
                BST.setCountToZero();

                // increment the range values by 16
                rangeMin += 16;
                rangeMax += 16;
            }

            // display the number of rows and columns in the new image
            System.out.println(rows + " " + columns);

            // initialize the array list counter to 0
            int listCount = 0;

            // for each row, cycle through
            for (int i = 0; i < rows; i++) {

                // for each column, cycle through
                for (int j = 0; j < columns; j++) {

                    // search for each pixel intensity the user entered in the order
                    // they were entered
                    BST.search(list.get(listCount));

                    // print a space
                    System.out.print(" ");

                    // increment the array list counter
                    listCount++;
                }

                // print out a new line
                System.out.println();
            }
        } // end of try block
        
        // if user's input is an incorrect data type, catch exception
        catch (InputMismatchException ex) {

            // display error message
            System.out.println("You entered an invalid data type. Exiting program.");

            // exit program
            System.exit(4);
        }
    }

}
