package org.testleaf.week4day1assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumberInArray {

    public static void main(String[] args) {
        //Declaring array
        int[] array1 =  {3, 2, 11, 4, 6, 7};

        // Convert arrays to List
        List<Integer> list1 = new ArrayList<>();
        for (int num: array1){
            list1.add(num);
        }
        
        //sorting array
        Collections.sort(list1);

        // Step 4: Get second largest element
        int secondLargest = list1.get(list1.size() - 2);

        //second largest number
        System.out.println("Second largest number in list is "+ secondLargest);



    }

}
