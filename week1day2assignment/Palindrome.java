package org.testleaf.week1day2assignment;

public class Palindrome {
    public static void main(String[] args) {
        int n = 1221;
        int originalnumber = n;
        int reversednumber = 0;

        while(n>0){
            int digit = n % 10;
            reversednumber = reversednumber * 10 + digit;
            n = n/10;
        }

        if (reversednumber == originalnumber){
            System.out.println(originalnumber + " is a Palindrome");
        }
        else{
            System.out.println(originalnumber + " is not a Palindrome");
        }

    }

}
