package org.example;

import java.util.Scanner;

//Library has 4 possible screens
//1 Method for each screen
//---Screen Structure---
//After the user enters their name, then the home screen will activate
//3 Options: Show Available Books, Show Checked Out Books, or Exit

//While(true) loop is a great idea for screens

//---------Home Screen----------
//Welcome to great library of gags and geniuses! How do you do?
// 1) Show Available Books
// 2) Show Checked Out Books
// 3) Buh-bye!

//Option 1: Show Available Books
//Gets everything EXCEPT DESCRIPTION
//Prompts the user to either check description or check out the book
//if description, then get the id, title, and description
//user can go back to the list once they've read the description
//if checking out the book, prompt the user for their name
//then, call the checkOut method

//---------Available Books--------
// C) Check Out Book
// X) Take Me Back!
// (Hint: Enter the book id to view the book description!)
// Have a column for each available book

// "Book Title" || ID: "id" || ISBN: "isbn"
// "Book Description"

//Option 2: Show Checked Out Books
//Gets everything except description, again
//Two options: Check in a book, or go back to the home screen
//if check in a book, have the user enter the id of the book
//Check in "Title"? Y/N (get title for this)
//if yes, goes back to home screen
//if no, goes back to the list
//if home screen, goes back to home screen

//---------Checked Out Books---------
// C) Check In Book
// X) Take Me Back!
// Have a column for each checked out book

// Enter the book id:
// [input]

// You have selected: "Book Name"
// Check in book?
// (YES) / (NO)

//Option 3: Exits out of the program

//use System.exit(0) to exit the program

public class Screen {

    Book[] inventoryOfBooks = {
            new Book(0,
            "978-1-928-63789-9",
            "Yoga To Help You Go To The Bathroom",
            "Featuring over 100 techniques to rev your bowels up, \nthis comprehensive yoga guide is your best friend \nto resolve any constipation issues! \nNot recommended for people with diarrhea.",
            false),
            new Book(1,
                    "978-1-626-73839-1",
                    "A Guide To Nihilism",
                    "A thorough guide on the two types of nihilism. \n'Nothing in this world matters!' and... \n'NOTHING IN THIS WORLD MATTERS!!!!!!!!'",
                    false
                    ),
            new Book(2,
                    "978-1-738-91793-6",
                    "Wilkins: The Master Of Hillbilly Rap",
                    "The one and only master of all things hillbilly, \nWilkins has rapped his way through his career by \ntelling stories of his country bumpkin life.",
                    true,
                    "Jim Slims"),
            new Book(3,
                    "978-1-627-62728-9",
                    "The Tortured Poets Department",
                    "This is author Taylor Swift's newest release. \nIt's hauntingly brilliant and incredibly captivating, \nbut one question remains... \nWas it her decision to release this at 2:00 AM?",
                    false)

    };


    public void loopBooks(boolean checkedOut){

        for(Book book : inventoryOfBooks){

        if (book.isCheckedOut() && checkedOut){
            book.setCheckedOut(true);
            System.out.println(book.getTitle() + book.getId() + book.getCheckedOutTo());
         }else{
            book.setCheckedOut(false);
            System.out.println(book.getTitle() + book.getId());
         }

        }

    }


    public void homeScreen(boolean isEnabled){

        while (isEnabled) {

            Scanner userInput = new Scanner(System.in);

            System.out.println("--------------Home Screen---------------");
            System.out.println("Welcome to great library of gags and geniuses! \nHow do you do?");
            System.out.println("""
                    1) Show Available Books
                    2) Show Checked Out Books
                    3) Buh-bye!
                    """);
            int homeScreenInput = userInput.nextInt();

            switch (homeScreenInput){
                case 1:
                    availableBooksScreen(true);
                    break;
                case 2:
                    checkedOutBooksScreen();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("That's not an option, buddy, so try again!");
                    homeScreen(true);
            }

            isEnabled = false;

        }

    }

    public void availableBooksScreen(boolean isEnabled){

        while (isEnabled) {

            loopBooks(false);

            Scanner userInput = new Scanner(System.in);

            String availBooksInput = userInput.nextLine();

            switch (availBooksInput.toUpperCase()) {
                case "C":
                    System.out.println("ur a nerd lol");
                    break;
                case "X":
                    homeScreen(true);
                    break;
                default:
                    System.out.println("That's not an option, buddy, so try again!");
                    availableBooksScreen(true);
            }

            isEnabled = false;

        }

    }

    public void checkedOutBooksScreen(){

        while (true) {

            loopBooks(true);

        }

    }

}
