/**
 * Proj1.java
 * Leo Chen / Section: 01B / Day: Thursday 1:05 - 2:55 PM
 * 
 * EXTRA CREDIT INCLUDED.
 * 
 * This program takes assumed values of ticket, t-shirt, and ticket fee prices of the final Taylor Swift show from her Eras Tour. 
 * It will prompt the user to enter how much money they have saved and will output the total cost before and after tax and also
 * the amount of money left after subtracting the costs from the inputted user amount. This program also allows for the user to input
 * multiple amounts of tickets and t-shirts purchased and will calculate the total amount. 
 */

 import java.util.Scanner;
 import java.text.DecimalFormat;
 public class Proj1 {
    public static void main(String[] args) {
        
        // Initizialing variables
        final double TICKET = 948;
        final double T_SHIRT = 49;
        final double TICKETFEE = 29.99;
        final double TAX = 9.2;


        // Scanner object and decimal format object
        Scanner scnr = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("$#,###,###.00");
        
        // Beginning information of taylor swift concert prices
        System.out.println("This program calculates the total price to attend a Taylor Swift concert");
        System.out.println("and determines if an individual has enough money saved to attend." + "\n");
        System.out.println("It makes the following assumptions:");
        System.out.println("    Adult ticket cost: " + df.format(TICKET));
        System.out.println("    Concert shirt cost: " + df.format(T_SHIRT));
        System.out.println("    Ticket fee: " + df.format(TICKETFEE));
        System.out.println("    Sales tax rate: " + String.format("%.2f", TAX) + "%\n");
        
        // User input for amount of tickets and t-shirts and the amount of money saved
        System.out.print("How many tickets are you purchasing? ");
        double ticketPurchase = scnr.nextDouble();
        System.out.print("How many T-Shirts are you planning to purchase? ");
        double shirtPurchase = scnr.nextDouble();
        System.out.print("Enter in how much money (total) you have saved: $");
        double moneySaved = scnr.nextDouble();

        // Final variables initialized for combined prices, tax price, combined prices with tax, and amount of money left
        double combined =  (ticketPurchase * TICKET) + (shirtPurchase * T_SHIRT) + (ticketPurchase * TICKETFEE);
        double combined_tax = combined * (TAX / 100);
        double total = combined + combined_tax;
        double total_after = moneySaved - total;

        // Final information for user of prices, like a bill
        System.out.println("");
        System.out.println("Total cost before tax: " + df.format(combined));
        System.out.println("Total tax: " + df.format(combined_tax));
        System.out.println("Overall cost after tax: " + df.format(total) + "\n");
        System.out.println("Amount left after all costs: " + df.format(total_after));
        if (total_after >= 0) {
            System.out.println("You have enough money! Have fun!");
        } else {
            System.out.println("You do not have enough money!");
        }
    }
 }  