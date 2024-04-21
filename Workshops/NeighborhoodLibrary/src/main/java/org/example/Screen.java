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

//Note:
//rough psuedocode is above, and final psuedocode is below!

public class Screen {

    //this is the array of all books in the library
    //available books have 5 filled out parameters, while checked out books have 6
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

    public void loopBooks(boolean bookStatus){

        boolean checkedOut = true;

        for(Book book : inventoryOfBooks){

                if (book.isCheckedOut() != checkedOut && !bookStatus){

                    System.out.println(book.getId() + " " + book.getTitle());

                }else if (book.isCheckedOut() == checkedOut && bookStatus){

                    System.out.println(book.getId() + " " + book.getTitle() + " " + book.getCheckedOutTo());

                }


        }

    }


    public void viewAvailableBookDescription(){

        boolean checkedOut = false;

        for(Book ignored : inventoryOfBooks){

            Scanner userInput = new Scanner(System.in);

            System.out.println("\nSo...do you want to take a closer look at one of our fine entries? \n(Hint: Enter the book ID to view the book description, or type in 100 to go back to all available books!)");

            int bookDescriptInput = userInput.nextInt();

                if (bookDescriptInput >= 0 && bookDescriptInput < inventoryOfBooks.length && inventoryOfBooks[bookDescriptInput].isCheckedOut() == checkedOut){

                    System.out.println("ID: " + inventoryOfBooks[bookDescriptInput].getId() + " Title: " + inventoryOfBooks[bookDescriptInput].getTitle() + " ISBN: " + inventoryOfBooks[bookDescriptInput].getIsbn() + " \n" + inventoryOfBooks[bookDescriptInput].getDescription());
                    break;

                }else if (bookDescriptInput == 100){

                    availableBooksScreen(true);
                    break;

                }else{

                    System.out.println("That's not an option, buddy, so try again!");
                    availableBooksScreen(true);
                    break;

                }

        }

    }

    public void viewCheckedOutBookDescription(){

        for(Book description : inventoryOfBooks){

            loopBooks(true);

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

            System.out.println("What do you want to do, pal?");
            int homeScreenInput = userInput.nextInt();

            switch (homeScreenInput){
                case 1:
                    availableBooksScreen(true);
                    break;
                case 2:
                    checkedOutBooksScreen(true);
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

            System.out.println(" \n--------------Available Books---------------");

            loopBooks(false);

            viewAvailableBookDescription();

            System.out.println("""
                    
                    So, you made it this far. What now?
                    ------------------------------------
                    C) Check Out Book
                    L) Take Me Back To The List!
                    X) Take Me Back To The Homepage!
                    """);

            Scanner userInput = new Scanner(System.in);

            String availBooksInput = userInput.nextLine();

            switch (availBooksInput.toUpperCase()) {
                case "C":
                    System.out.println("ur a nerd lol");
                    break;
                case "L":
                    availableBooksScreen(true);
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

    public void checkedOutBooksScreen(boolean isEnabled){

        while (isEnabled) {

            loopBooks(true);

            isEnabled = false;

        }

    }

}
