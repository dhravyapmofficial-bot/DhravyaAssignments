package org.testleaf.week2day1assignment;

public class LibraryManagement {
    public static void main(String[] args) {

        Library callLibrary = new Library(); //creating object for Library class
        callLibrary.addBook("Selenium Learning"); //calling method from Library class
        callLibrary.issueBook(); //calling method from Library class

    }

}
