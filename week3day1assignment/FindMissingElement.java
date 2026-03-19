package org.testleaf.week3day1assignment;

import java.util.Arrays;

public class FindMissingElement {

    public static void main(String[] args) {
        
        int[] array = {1,4,3,2,8,6,7};
        
        //printing length of array
        int numberOfData = array.length;
        System.out.println("Length of Array is " + numberOfData);

        //sorting array
        Arrays.sort(array);
        
        //Print entire data in sorted order
        for(int i=0; i<numberOfData; i++)
        {
            System.out.println(array[i]);
        }

        //To find missing element in array

        for(int i=0; i<array.length; i++)
        {
            if(array[i] != i+1)
            {
                System.out.println("Missing number is "+(i+1));
                break;
            }
        }
        
    }

}
