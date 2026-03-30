package org.testleaf.week4day2assignment;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetInterface {

    public static void main(String[] args) {

        String companyName = "google";

        //Create a Set to store unique characters
        Set<Character> uniqueChars = new LinkedHashSet<>();

        for (int i = 0; i < companyName.length(); i++) {
            char ch = companyName.charAt(i);
            uniqueChars.add(ch); // Set automatically ignores duplicates
        }

        //Print unique characters
        for (char ch : uniqueChars) {
            System.out.print(ch);
        }
    }

}
