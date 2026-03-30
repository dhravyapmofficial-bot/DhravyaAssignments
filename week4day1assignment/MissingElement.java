package org.testleaf.week4day1assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElement {

    public static void main(String[] args) {
        
        int array[]=  {1, 2, 3, 4, 10, 6, 8};
        
        //convert array to list
        List<Integer> list = new ArrayList<>();
        for(int num: array){
            list.add(num);
        }

        //sort the list
        Collections.sort(list);
        System.out.println("Sorted list is "+list);

        //Missing elements
        System.out.println("Missing elements are:");


        for (int i = 0; i < list.size() - 1; i++) {

            int current = list.get(i);
            int next = list.get(i + 1);

            // Check gap
            if (next != current + 1) {

                // Print all missing numbers between current and next
                for (int j = current + 1; j < next; j++) {
                    System.out.println(j);
                }
            }
        }


    }

}
