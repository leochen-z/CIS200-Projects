/**
 * Proj3.java
 * 
 * Leo Chen/Section: 01B/ Date: Thursday 1:05 - 2:55 PM
 * 
 * This program takes in 4 inputs, two being distint x-values, two others being y-values (distinct or not). The program will then output
 * a slope-intercept form that is rounded to two decimal points. The program will then output a graph that shows two points, the two points
 * correlating to the 4 values inputed in, converted into 2 coordinate points. After the graph has been outputted, the program will ask if
 * the user wants to run the program again. The program checks for the same 2 coordinate points, the same x-values, and checks if the user
 * inputed values between (0,9) inclusive.
 * 
 */

import java.util.*;
public class Proj3 {
    public static void main(String[] args) {

        Scanner scnr = new Scanner (System.in);
        boolean loop = true;

        while (loop) {
            double x1 = 0;
            double x2 = 0;
            double y1 = 0;
            double y2 = 0;
            double slope = 0;
            double yint = 0;
            do {
                System.out.print("Enter x1: ");
                x1 = Double.parseDouble(scnr.nextLine());
                System.out.print("Enter y1: ");
                y1 = Double.parseDouble(scnr.nextLine());
                System.out.print("Enter x2: ");
                x2 = Double.parseDouble(scnr.nextLine());
                System.out.print("Enter y2: ");
                y2 = Double.parseDouble(scnr.nextLine());
                if (x1 == x2 && y1 == y2) {
                    System.out.println("Point values must be different.");
                } else if (x1 == x2) {
                    System.out.println("Line between points must have a slope.\n (i.e. x1 and x1 must differ)");
                } else if ((x1 < 0) || (x1 > 9) || (x2 < 0) || (x2 > 9) || (y1 < 0) || (y1 > 9) || (y2 < 0) || (y2 > 9)) {
                    System.out.println("All points must be between (0,0) and (9,9)");
                }
            } 
            while ((x1 == x2 && y1 == y2) || (x1 == x2) || ((x1 < 0) || (x1 > 9) || (x2 < 0) || (x2 > 9) || (y1 < 0) || (y1 > 9) || (y2 < 0) || (y2 > 9))); // end do while loop

            slope = (y2 - y1) / (x2 - x1);
            yint = y1 - slope * x1;

            System.out.printf("\n\ny = %.2f" + "x" + " + %.2f\n", slope, yint); // Printing out the slope-intercept form using printf      

            for (int i = 9; i >= -1; i--) {
                if (i == -1) { 
                    System.out.print(" 0 1 2 3 4 5 6 7 8 9"); // Blank line for the bottom x-coordinates
                } else {
                    System.out.print(i);
                }

                for (int j = 0; j <= 10; j++) {
                    if (i == 0) { // Does the zero line and also coordinates where y = 0
                        if ((y1 == 0 && x1 == j) || (y2 == 0 && x2 == j)) {
                            System.out.print("*-");
                        } else {
                            System.out.print("--");
                        }
                    } else if (((x1 == 0 && y1 == i) && x1 == j) || ((x2 == 0 && y2 == i) && x2 == j)) { // Checks for when x = 0 and adds in a point
                        System.out.print(" *");
                    } else if (j == 0 && i != -1) { // Adds in the " | " to the graph
                        System.out.print(" |");
                    } else if ((y1 == i && x1 == j) || (y2 == i && x2 == j)) { // Adds in the point for when x || y != 0
                        System.out.print("*");
                    } else { // Adds in whitespace
                        System.out.print("  ");
                    }

                    if (j == 10) { // new line
                        System.out.println("");
                    }   
                } // end inner loop
            } // end outer loop
            System.out.print("\nRun program again? (y/n) ");
            char goAgain = scnr.nextLine().charAt(0);

            if (goAgain == 'n' || goAgain == 'N') { // Prompts the user to ask if they want to go again
                loop = false;
            } else {
                loop = true;
            }
        } // end main loop
    } // end main
 } // end class