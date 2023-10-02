/** 
* Proj4.java
* Leo Chen / Section: 01B / Day: Thursday / Time: 1:05 - 2:55 PM
* 
* This program is based off of the game Five Card Draw Poker. This program will first ask for the user to enter in their username and password correctly. If the user does not enter in the right
* username or password in three tries, the program will exit. If the user successfully enters in the right credentials, the program will randomly draw a deck of 5 cards and say what the user
* was dealt. The program will then prompt the user if they want to re-run the program again or not. To re-run the program, the user can only enter in 'Y' or 'y' and 'N' or 'n' to exit the program.
* If the user enters in any other character, the program will keep prompting until a correct character is entered. 
*/

import java.util.*;
public class Proj4 {
    public static void main(String[] args) {
        // Objects declared
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
         
        // Constants declared and initialized
        final String LAST_NAME = "Chen";
        final String WID = "890207824";
        final String PASSWORD = "CIS200$Fall23";
 
        /** Username generated */
        sb.append(LAST_NAME.substring(0,4));
        sb.append(WID.substring(WID.length() - 4, WID.length()));
        String username = sb.toString();
 
         // Variables declared
        String usernameInput;
        String passwordInput;
        int errorCount = 1;
        int count = 0;
        int highCard = 0;
        char goAgain = 'a';

        // Arrays declared and/or initialized
        int[] fullValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] checker = new int[13];
 
         System.out.println("Username generated: " + username);
 
         /** Username & Password Prompt  */
         System.out.print("Please enter your username: ");
         usernameInput = scanner.nextLine();
         System.out.print("Please enter your password: ");
         passwordInput = scanner.nextLine();
 
         while (!passwordInput.equals(PASSWORD) || !usernameInput.equalsIgnoreCase(username)) {
             if (errorCount == 3) {
                 System.out.println("Invalid Username and/or Password entered 3 times...EXITING");
                 System.exit(0);
             }
             System.out.println("Invalid Username and/or Password");
             System.out.print("Please enter your username: ");
             usernameInput = scanner.nextLine();
             System.out.print("Please enter your password: ");
             passwordInput = scanner.nextLine();
             errorCount++;
         }
         
 
         System.out.println("**Welcome to the 2023 Las Vegas Poker Festival!**");
         System.out.println("\t(Application developed by Leo Chen)");
 
         do {
            int flushCount = 0;
            int straightCount = 0;
            boolean flush = false;
            boolean straight = false;
            System.out.println("\nShuffling cards...\nDealing the cards...\nHere are your five cards...\n");
            
          

            /**  Card creation and place to comment out */
            int[] values = new int[5];
            int[] suits = new int[5];
            for (int i = 0; i < values.length; i++) {
                int s = rand.nextInt(4) + 1;
                int v = rand.nextInt(13) + 2;
                //System.out.println("Card " + (i + 1) + " is " + v + " with suit " + s);
                suits[i] = s; // Generates random value for suit
                values[i] = v; // Generates random value for card
          
                if (i >= 1) { // Checks for duplicate cards. Takes 's = suit' and 'v = value' and iterates in a descending order through the array to find matches
                  for (int j = i; j >= 1; j--) {
                    if (v == values[j - 1] && s == suits[j - 1]) {
                      //System.out.println("true");
                      //System.out.println(Arrays.toString(values));
                      //System.out.println(Arrays.toString(suits));
                      values = new int[5];
                      suits = new int[5];
                      i = 0;
                      values[i] = v;
                      suits[i] = s;
                    }
                  }
                }
            } // end of loop and card creation and validation

            // System.out.println(Arrays.toString(values));
            // System.out.println(Arrays.toString(suits));
            for (int i = 0; i < values.length; i++) { // Loop through the dealt deck
                 if (values[i] == 11) { // Check for Jack
                     if (suits[i] == 1) {
                         System.out.println("\tJack of Spades");
                     } else if (suits[i] == 2) {
                         System.out.println("\tJack of Clubs");
                     } else if (suits[i] == 3) {
                         System.out.println("\tJack of Hearts");
                     } else {
                         System.out.println("\tJack of Diamonds");
                     }
                 } else if (values[i] == 12) { // Check for queen
                     if (suits[i] == 1) {
                         System.out.println("\tQueen of Spades");
                     } else if (suits[i] == 2) {
                         System.out.println("\tQueen of Clubs");
                     } else if (suits[i] == 3) {
                         System.out.println("\tQueen of Hearts");
                     } else {
                         System.out.println("\tQueen of Diamonds");
                     }
                 } else if (values[i] == 13) { // Check for King
                     if (suits[i] == 1) {
                         System.out.println("\tKing of Spades");
                     } else if (suits[i] == 2) {
                         System.out.println("\tKing of Clubs");
                     } else if (suits[i] == 3) {
                         System.out.println("\tKing of Hearts");
                     } else {
                         System.out.println("\tKing of Diamonds");
                     }
                 } else if (values[i] == 14) { // Check for Ace
                     if (suits[i] == 1) {
                         System.out.println("\tAce of Spades");
                     } else if (suits[i] == 2) {
                         System.out.println("\tAce of Clubs");
                     } else if (suits[i] == 3) {
                         System.out.println("\tAce of Hearts");
                     } else {
                         System.out.println("\tAce of Diamonds");
                     }
                } else {
                    if (suits[i] == 1) {
                        System.out.println("\t" + values[i] + " of Spades");
                    } else if (suits[i] == 2) {
                        System.out.println("\t" + values[i] + " of Clubs");
                    } else if (suits[i] == 3) {
                        System.out.println("\t" + values[i] + " of Hearts");
                    } else {
                        System.out.println("\t" + values[i] + " of Diamonds");
                    }  
                }
            } // end loop
            System.out.println();

            Arrays.sort(values);
            // System.out.println(Arrays.toString(values));
            highCard = values[values.length - 1];

            for (int i = 1; i < values.length; i++) {
                if (values[i] - 1  == values[i - 1]) {
                    straightCount += 1;
                }
                if (suits[i] == suits[i - 1]) {
                    flushCount += 1;
                }
            }
            for (int i = 0; i < fullValues.length; i++) {
                for (int j = 0; j < values.length; j++) {
                    if (fullValues[i] == values[j]) {
                        count++;
                    }
                }
                checker[i] = count;
                count = 0;
            }

            if (flushCount == values.length - 1) {
                flush = true;
            }

            if (straightCount == values.length - 1) {
                straight  = true;
            }
            // System.out.println(Arrays.toString(checker));
            for (int i = 0; i < checker.length; i++) {
                if (checker[9] == 1 && checker[10] == 1 && checker[11] == 1 && checker[12] == 1 && flush) {
                    System.out.println("You were dealt a Royal Flush.");
                    i = 999;
                } else if (straight && flush) {
                    System.out.println("You were dealt a Straight Flush.");
                    i = 999;
                } else if (checker[i] == 4) {
                    System.out.println("You were dealt a Four of a Kind.");
                    i = 999;
                } else if (checker[i] == 3 || checker[i] == 2) {
                    if (checker[i] == 3) {
                        for (int j = i + 1; i < checker.length; j++) {
                            if (checker[j] == 2) {
                                System.out.println("You were dealt a Full House.");
                                break;
                            } else if (j == checker.length - 1) {
                                System.out.println("You were dealt a Three of a Kind.");
                                break;
                            }
                        } 
                    } else if (checker[i] == 2) {
                        for (int j = i + 1; i < checker.length; j++) {
                            if (checker[j] == 3) {
                                System.out.println("You were dealt a Full House.");
                                break;
                            } else if (checker[j] == 2) {
                                System.out.println("You were dealt a Two Pair.");
                                break;
                            } else if (j == checker.length - 1) {    
                                System.out.println("You were dealt a Pair.");
                                break;
                            }
                        } 
                    }
                    i = 999;
                } else if (flush) {
                    System.out.println("You were dealt a Flush.");
                    i = 999;
                } else if (straight) {
                    System.out.println("You were dealt a Straight.");
                    i = 999;
                } else if (i == 12 && checker[i] != 2) {
                    if (highCard == 11) {
                        System.out.println("High card is a(n) Jack");
                        break;
                    } else if (highCard == 12) {
                        System.out.println("High card is a(n) Queen");
                        break;
                    } else if (highCard == 13) {
                        System.out.println("High card is a(n) King");
                        break;
                    } else if (highCard == 14) {
                        System.out.println("High card is a(n) Ace");
                        break;
                    } else {
                        System.out.println("High card is a(n) " + highCard);
                        break;
                    }
                }
            } // end loop

            System.out.print("Play Again (Y or N)? ");
            goAgain = scanner.next().charAt(0);
            while (goAgain != 'N') {
                if (goAgain == 'n') {
                    break;
                } else if (goAgain == 'Y' || goAgain == 'y') {
                    break;
                }
                System.out.print("Play Again (Y or N)? ");
                goAgain = scanner.next().charAt(0);
                
            }
        } while (goAgain == 'Y' || goAgain == 'y');

        scanner.close();
    } // end main
} // end class