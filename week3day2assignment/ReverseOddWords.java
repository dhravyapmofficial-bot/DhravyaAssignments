package org.testleaf.week3day2assignment;

public class ReverseOddWords {
    public static void main(String[] args) {

        String test = "I am a software tester";

        String[] words = test.split(" ");

        for (int i = 0; i < words.length; i++) {

            // If index is odd
            if (i % 2 != 0) {

                char[] ch = words[i].toCharArray();

                // Print in reverse
                for (int j = ch.length - 1; j >= 0; j--) {
                    System.out.print(ch[j]);
                }
                System.out.print(" ");

            } else {
                // Even index → print as it is
                System.out.print(words[i] + " ");
            }
        }
    }
}

