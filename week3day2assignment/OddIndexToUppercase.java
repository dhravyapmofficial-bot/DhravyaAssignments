package org.testleaf.week3day2assignment;

public class OddIndexToUppercase {

    public static void main(String[] args) {
        
        String test = "changeme"; 

        //converting string to character array
        char[] charArray = test.toCharArray();

        for(int i=charArray.length-1; i>=0; i--){

            //check for odd index
            if(i%2 !=0)
            {
               charArray[i] = Character.toUpperCase(charArray[i]);
            }

        }
        
        //convert back to string
        String result = new String(charArray);
        System.out.println("Converted odd index values to uppercase is "+ result); 
        

    }

}
