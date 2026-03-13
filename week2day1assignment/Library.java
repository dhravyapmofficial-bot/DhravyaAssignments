package org.testleaf.week2day1assignment;

public class Library {

    public String addBook(String bookTitle) // defining the method
    {
        System.out.println("Book added successfully" );
        return bookTitle;
    }

    public void issueBook() // defining the method
    {
        System.out.println( "Book issued successfully");
    }

public static void main(String[] args) {
    
    Library options = new Library(); // creating an object for class
    options.addBook("Selenium Learning"); // Calling method
    options.issueBook(); // Calling method

}

}



