package org.testleaf.week1day2assignment;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 8, firstnumber =0, secondnumber =1;
        System.out.println("Fibonacci series of range 8:");

        for (int i=1;i<=n;++i)
        {
            System.out.println(firstnumber);
            int nextnumber = firstnumber + secondnumber;
            firstnumber =  secondnumber;
            secondnumber = nextnumber;

        }
    }

}
