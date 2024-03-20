/**
 * Given as input an unsorted array A of non-negative integers and an integer target K, write a method
 * sumTarget that finds a subarray of A with a sum equal to K (if one exists). The method should return
 * the indices at which the subarray starts and ends. If no subarray exists, the start and end indices will be
 * set to -1
 */

import java.util.Arrays;

public class SumTarget {

    /**
     * Determines if there is a subarray or not.
     * If so, returns indies of the total.
     * If not, returns [-1, -1].
     * @param A
     * @param K
     * @return x
     */
    public static int[] sumTarget(int[] A, int K){

        int[] x = new int[]{-1, -1};

        int start_index = 0;
        int end_index = 0;
        int total = 0;


        while(start_index < A.length){

            if(total < K && end_index < A.length){ //if we haven't found a sum = to target & we're not at the end

                total = total +A[end_index];
                end_index++;
            }

            else if(total > K){ //if total is greater than target

                total = total - A[start_index]; //subtract index values from the total
                start_index++;
            }

            else{ //if the total = the target

                //update x to the correct indices
                x[0] = start_index;
                x[1] = end_index - 1;
                break;
            }
        }

        //checks the total value with the target value
        if(x[0] == x[1] && start_index + end_index != K){
            x[0] = -1;
            x[1] = -1;
        }

        return x;
    }


    public static void main(String[] args){

        int[] A = new int[]{1, 2, 3, 7, 5};
        int K = 12;

        int[] A2 = new int[]{1, 2, 3, 7, 5};
        int K2 = 5;

        int[] A3 = new int[]{1, 2, 3, 7, 5};
        int K3 = 7;

        int[] A4 = new int[]{1, 2, 3, 7, 5};
        int K4 = 11;

        System.out.println("Test Case 1:");
        System.out.println(Arrays.toString(sumTarget(A, K)));
        System.out.println();

        System.out.println("Test Case 2:");
        System.out.println(Arrays.toString(sumTarget(A2, K2)));
        System.out.println();

        System.out.println("Test Case 3:");
        System.out.println(Arrays.toString(sumTarget(A3, K3)));
        System.out.println();

        System.out.println("Test Case 4:");
        System.out.println(Arrays.toString(sumTarget(A4, K4)));
        System.out.println();
    }
}
