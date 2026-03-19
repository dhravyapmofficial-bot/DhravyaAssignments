package org.testleaf.week3day2assignment;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        
        //Define 2 strings
        String str1 = "stops";
        String str2 = "potss";

        //Check and print lenth of 2 strings
        int lengthOfString1 = str1.length();
        System.out.println("Length of string 1 is "+lengthOfString1);
        int lengthOfString2 = str2.length();
        System.out.println("Length of string 2 is "+lengthOfString2);

        if(lengthOfString1 != lengthOfString2){
            System.err.println("\"Lengths mismatch, therefore the strings are not an Anagram");
        }

        //If lenths are equals, then converting string to character arrays
        else{
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            //sorting both character arrays
            Arrays.sort(charArray1);
            System.out.println(charArray1);
            Arrays.sort(charArray2);
            System.out.println(charArray2);

            //Check if the sorted arrays are equal 
            if(Arrays.equals(charArray1, charArray2)){
                System.err.println("The given strings are Anagram." );
            }
            else{
                System.out.println("The given strings are not an Anagram.");
            }
            
        }

        

    }

}
