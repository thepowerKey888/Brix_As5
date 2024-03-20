/**
 * This program uses a Hash Table to test whether S is a subset of T.
 *
 * S is considered a subset of T if every element in S is an element in T.
 * (Not necessarily in the same order).
 */

import java.util.Hashtable;
public class SubInteger {

    /**
     * This method uses a HashTable to check whether
     * S is a sub set of T.
     * @param t
     * @param s
     * @return sub
     */
    public static String substring(int[] t, int[] s){

        String sub = "yes";

        //first: record the occurrences of the chars in s in a Hashtable
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for(int i = 0; i < t.length; i++){

            if(table.containsKey(t[i])){ //if the char has occurred
                table.put(t[i], table.get(t[i]) + 1); //update the # of occurrences (value)
            }
            else{ //if the char has not occurred
                table.put(t[i], 1); //add it to the table
            }
        }

        //second: check if the ints in t exist in s
        for(int i = 0; i < s.length; i++){

            int occ_t = 0; //# of occurrences of the int in t

            if(table.containsKey(s[i])){ //if it exists in the table

                occ_t = occ_t +1; //update the # of occurrences to 1

                //third: check how many times total the int exists in t
                for(int j = i+1; j < s.length; j++){
                    if(s[j] == s[i]){
                        occ_t = occ_t +1;
                    }
                }
                if(table.get(s[i]) == occ_t){

                    sub = "yes";
                }
                else{
                    sub = "no";
                    return sub;
                }

            }
            else{
                sub = "no";
                return sub;
            }
        }
        return sub;
    }

    public static void main(String[] args){

        int[] t = new int[]{1, 2, 3, 52, 32, 54};
        int[] s = new int[]{32, 3};
        //yes

        int[] t2 = new int[]{54, 32, 99};
        int[] s2 = new int[]{89, 32, 54, 32, 3};
        //no

        int[] t3 = new int[]{4, 6, 2, 88, 402, 797, 11};
        int[] s3 = new int[]{4};
        //yes

        int[] t4 = new int[]{4, 6, 2, 88, 402, 797, 11};
        int[] s4 = new int[]{99, 22, 6};
        //no

        int[] t5 = new int[]{4, 6, 2, 88, 402, 797, 11};
        int[] s5 = new int[]{797, 2, 11, 4};
        //yes

        System.out.println(substring(t, s));
        System.out.println(substring(t2, s2));
        System.out.println(substring(t3, s3));
        System.out.println(substring(t4, s4));
        System.out.println(substring(t5, s5));

    }


}
