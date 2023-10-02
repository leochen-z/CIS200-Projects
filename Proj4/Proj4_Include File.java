/*  

Copy these hardcoded values to test each of the possible hands.

Your project must initially work with your random card generator.
For further testing, comment out the random portion and use these hard-coded values

Assumes suits are numbered 1-4
Assumes 11=Jack, 12=Queen 13=King 14=Ace
*/
  
// Used for testing different hands
//  ...first comment out random card generator portion of your code
  
// Royal Flush 
  int[] values = {10, 12, 14, 13, 11}; 
  int[] suits = {1,1,1,1,1};

// Straight Flush 
  int[] values = {9, 7, 8, 6, 5}; 
  int[] suits = {1,1,1,1,1};

// 4 of kind 
  int[] values = {9, 7, 9, 9, 9}; 
  int[] suits = {1,1,3,4,2};

// Full House 
  int[] values = {9, 7, 9, 7, 9}; 
  int[] suits = {1,2,3,4,2};

// Flush 
  int[] values = {9, 10, 8, 6, 5}; 
  int[] suits = {1,1,1,1,1};

// Straight 
  int[] values = {9, 7, 8, 6, 5}; 
  int[] suits = {1,2,4,3,1};

// 3 of kind 
  int[] values = {9, 7, 9, 2, 9}; 
  int[] suits = {1,2,3,4,2};

// Two Pair 
  int[] values = {9, 7, 9, 2, 7}; 
  int[] suits = {1,2,3,4,1};

// One Pair 
  int[] values = {9, 7, 8, 2, 7}; 
  int[] suits = {1,2,3,4,1};

// High Card (Ace) 
  int[] values = {9, 7, 8, 14, 11}; 
  int[] suits = {1,2,3,4,1};

  



 