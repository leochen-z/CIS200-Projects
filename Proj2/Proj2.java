/** 
 * Proj2.java
 * Leo Chen / Section: 01B / Day: Thursday 1:05 - 2:55 PM
 * 
 * EXTRA CREDIT INCLUDED
 * 
 * 
 * This program takes in inputs for filing status and amount of gross income earned in one year. The program then computes the taxes owed 
 * from the gross income using the 2023 federal income tax bracket. The program also computes the effective tax rate on the user. The program
 * will repeat if the user does not enter in a valid status (in integers) for filing status and allows the user to run the program as many
 * times as possible. 
 */


import java.text.DecimalFormat;
import java.util.*;

public class Proj2 {
    public static void main(String[] args) {
        // Objects, constants, and variables initialized

        Scanner scnr = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("$#,###,###.##");

        final int SINGLE = 13850;
        final int MARRIED_FILING_SEP = 13850;
        final int MARRIED_FILING_JOINT = 27700;
        final int HEAD_OF_HOUSE = 20800;

        double[] filing_status = {SINGLE, HEAD_OF_HOUSE, MARRIED_FILING_JOINT, MARRIED_FILING_SEP};
        double[] singleBrackets = {578125, 231250, 182100, 95375, 44725, 11000, 0};
        double[] marriedJoint = {693750, 462500, 364200, 190750, 89450, 22000, 0};
        double[] headOfHousehold = {578100, 231250, 182100, 95350, 59850, 15700, 0};
        double[] taxRate = {.37, .35, .32, .24, .22, .12, .10};

        int inputNum;
        int grossIncome;
        double taxableIncome;
        double taxOwed = 0;
        double effectiveTaxRate;

        boolean loop = true;

        while (loop) {
            System.out.println("Choose a filing status:");
            System.out.println("\t(1) Single");
            System.out.println("\t(2) Head of household");
            System.out.println("\t(3) Married filing jointly");
            System.out.println("\t(4) Married filing separately");
            System.out.print("Enter your option, 1-4: ");
            inputNum = Integer.parseInt(scnr.nextLine());

            while (inputNum <= 0 || inputNum >= 5) {
                System.out.println("**Invalid value entered. Enter 1-4 only.");
                System.out.print("Enter your option, 1-4: ");
                inputNum = Integer.parseInt(scnr.nextLine());
            }

            System.out.print("Enter your gross income from 2023: $");
            grossIncome = Integer.parseInt(scnr.nextLine());
            
            if (grossIncome - SINGLE <= 0 || grossIncome - MARRIED_FILING_SEP <= 0 || grossIncome - MARRIED_FILING_JOINT <= 0 || grossIncome - HEAD_OF_HOUSE <= 0) {
                for (int i = 0; i < filing_status.length; i++) {
                    if (grossIncome - filing_status[i] <= 0 && inputNum == (i + 1)) {
                        taxableIncome = grossIncome - filing_status[i];
                        taxOwed = 0;
                        System.out.println("\nYour taxable income for 2023 is: " + df.format(taxableIncome));
                        System.out.println("Taxes owed: " + df.format(taxOwed));
                    }
                }
            } else {
                if (inputNum == 1 || inputNum == 4) {
                    if (inputNum == 1) {
                        taxableIncome = grossIncome - SINGLE;
                    } else {
                        taxableIncome = grossIncome - MARRIED_FILING_SEP;
                    }
                    for (int i = 0; i < singleBrackets.length; i++) {
                        if (taxableIncome > singleBrackets[i]) {
                            for (int j = i; j < (singleBrackets.length) ; j++) {
                            taxOwed = (taxOwed + (taxableIncome - singleBrackets[j]) * taxRate[j]);
                            taxableIncome = singleBrackets[j];
                            }
                        }
                    }
                effectiveTaxRate = taxOwed / (grossIncome - SINGLE) * 100;
                System.out.println("\n\nYour taxable income is: " + df.format(grossIncome - SINGLE));
                System.out.println("Taxes owed: " + df.format(Math.round(taxOwed)));
                System.out.printf("Your effective tax rate is %.2f%%\n", effectiveTaxRate);
                } else if (inputNum == 2) {
                    taxableIncome = grossIncome - HEAD_OF_HOUSE;
                    for (int i = 0; i < headOfHousehold.length; i++) {
                        if (taxableIncome > headOfHousehold[i]) {
                            for (int j = i; j < (headOfHousehold.length) ; j++) {
                            taxOwed = (taxOwed + (taxableIncome - headOfHousehold[j]) * taxRate[j]);
                            taxableIncome = headOfHousehold[j];
                            }
                        }
                    } 
                effectiveTaxRate = taxOwed / (grossIncome - HEAD_OF_HOUSE) * 100;
                System.out.println("\nYour taxable income is: " + df.format(grossIncome - HEAD_OF_HOUSE));
                System.out.println("Taxes owed: " + df.format(Math.round(taxOwed)));
                System.out.printf("Your effective tax rate is %.2f%%\n", effectiveTaxRate);
                } else {
                    taxableIncome = grossIncome - MARRIED_FILING_JOINT;
                    for (int i = 0; i < marriedJoint.length; i++) {
                        if (taxableIncome > marriedJoint[i]) {
                            for (int j = i; j < (marriedJoint.length) ; j++) {
                            taxOwed = (taxOwed + (taxableIncome - marriedJoint[j]) * taxRate[j]);
                            taxableIncome = marriedJoint[j];
                            }
                        }
                    } 
                effectiveTaxRate = taxOwed / (grossIncome - MARRIED_FILING_JOINT)* 100;
                System.out.println("\nYour taxable income is: " + df.format(grossIncome - MARRIED_FILING_JOINT));
                System.out.println("Taxes owed: " + df.format(Math.round(taxOwed)));
                System.out.printf("Your effective tax rate is %.2f%%\n", effectiveTaxRate);
                }
            }
            System.out.print("\nDo you wish to run the program again? (Y/N): ");
            char run = scnr.nextLine().charAt(0);
            if (run == 'N' || run == 'n') {
                loop = false;
            } else {
                System.out.println("");
                taxOwed = 0;
                effectiveTaxRate = 0;
            }
        }
    } // main
} // class
