package org.testleaf.week3day2assignment;

public class RemoveDuplicateWords {
    public static void main(String[] args) {

        String text = "We learn Java basics as part of java sessions in java week1";

        // Split the string into words
        String[] words = text.split(" ");

        int count = 0;

        // Nested loops to compare words
        for (int i = 0; i < words.length; i++) {

            if (words[i].equals("")) {
                continue;
            }

            for (int j = i + 1; j < words.length; j++) {
                
                if (words[i].equalsIgnoreCase(words[j])) {
                    words[j] = ""; // replace duplicate with empty string
                    count++;
                }
            }
        }

        // Print result only if duplicates found
        if (count > 0) {
            System.out.print("Output: ");
            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + " ");
            }
        } else {
            System.out.println("No duplicate words found.");
        }
    }
}

