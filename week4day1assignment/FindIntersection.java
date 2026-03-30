package org.testleaf.week4day1assignment;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {
    public static void main(String[] args) {

        // Declare arrays
        int[] arr1 = {3, 2, 11, 4, 6, 7};
        int[] arr2 = {1, 2, 8, 4, 9, 7};

        // Convert arrays to List
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : arr1) {
            list1.add(num);
        }

        for (int num : arr2) {
            list2.add(num);
        }

        // Find intersection using List
        System.out.println("Intersection elements are:");

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    System.out.print(list1.get(i) + " ");
                }
            }
        }
    }
}