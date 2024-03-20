/**
 * Program that takes an array of Strings and uses radix sort
 * to sort the array lexicographically.
 */

import java.util.Arrays;

public class RadixSort {

    /**
     * Utility function used in radix sort that returns
     * the longest word from the input array.
     * @param a
     * @param l
     * @return longest
     */
    public static int getMax(String[] a, int l){

        for(int i = 0; i < a.length; i++){
            if (a[i].length() == 0 || a[i].length() > 1000) {

                System.out.println("Length of one of the words is too short or too long!");
            }
        }

        int longest = a[0].length(); //gets length of first string in array
        for(int i = 1; i < l; i++){
            if(a[i].length() > longest){ //checks if there's a longer string
                longest = a[0].length();
            }
        }
        return longest;
    }

    /**
     * Function to do counting sort of a.
     * @param a
     * @param l
     * @param x
     */
    public static void countSort(String[] a, int l, int x){

        String[] s = new String[l]; //creates a new array equal to input
        int[] count = new int[257]; //counting array

        Arrays.fill(count, 0); //fills the array with dummy values of 0

        //calculates the index of the character at position x in the ith string in a
        for(int i = 0; i < l; i++){
            int index;
            if(x < a[i].length()){ //checks if x is less than the string at index i

                //converts the char at position x into ASCII value & makes it an int
                //adds one to ensure index falls in range of [1, 256]
                index = (int) a[i].charAt(x) +1;
            }
            else {
                index = 0;
            }
            count[index]++;
        }

        //updates count to hold cumulative counts
        for(int i = 1; i < 257; i++){
            count[i] +=count[i-1];
        }

        //constructs sorted array s based on the counts in count
        //calculates index of char at position x & uses cumulative count in count
        //to determine correct position
        for(int i = l - 1; i >= 0; i--){
            int index;
            if(x < a[i].length()){
                index = (int) a[i].charAt(x) + 1;
            }
            else{
                index = 0;
            }
            s[count[index]-1] = a[i];
            count[index]--;
        }
        System.arraycopy(s, 0, a, 0, l); //copying s back to original array a

    }

    /**
     * Main function of radix sort.
     * @param a
     * @param x
     */
    public static void radixSort(String[] a, int x){

        for(int i = 0; i < a.length; i++){ //ensures all chars are lowercase
           a[i] = a[i].toLowerCase();
        }
        int max = getMax(a, x);
        for(int max_length = max; max_length > 0; max_length--){
            countSort(a, x, max_length-1);
        }
    }

    public static void main(String[] args){

        String[] words = new String[] {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman",
                "hydra", "surtr"};

        System.out.println("");
        System.out.println("Words before sorting:");
        System.out.println("");
        //prints words before sorting
        for(int i =0; i <words.length; i++){
            System.out.println(words[i] + " ");
        }

        radixSort(words, words.length);

        System.out.println("");
        System.out.println("Words after sorting:");
        System.out.println("");
        //prints words after sorting
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i] + " ");
        }

    }


}

