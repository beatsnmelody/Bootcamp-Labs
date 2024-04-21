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

    //this is the array of all 20 books in the library
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
                    false),
            new Book(4,
                    "978-1-829-31526-6",
                    "The Seven Elements In Genshin Impact And How To Use Them",
                    "This is your one-stop-shop to not only know \nmore about each of Genshin Impact's seven elements, \nbut also your guide to learning about \nelemental effects and reactions.",
                    false),
            new Book(5,
                    "978-1-010-00011-1",
                    "How To Translate Binary Into Words And Vice Versa",
                    "01010100 01110010 01111001 \n00100000 01101001 \n01110100 00100001",
                    false),
            new Book(6,
                    "978-1-638-02872-7",
                    "The Tarot Bible",
                    "Featuring contributions from several well-known \ntarot experts, this book covers the major and minor \narcana, as well as other topics such as \nnumerology and the zodiac.",
                    false),
            new Book(7,
                    "978-1-602-61789-9",
                    "Toilet In Wonderland",
                    "This story follows a girl named Mira, \nwho explores an imaginary world created by her constipation. \nWhat will happen as her constipation levels lower? \nFind out now!",
                    true,
                    "Jimbo Beans"),
            new Book(8,
                    "978-1-376-88653-5",
                    "The History Of Emoticons",
                    "From the original smiley face emoticon, :-), \nto the modern day emoticons known as emojis, \nthis is a thorough history of the funny faces \nthat brighten up our texts.",
                    false),
            new Book(9,
                    "978-1-467-56798-0",
                    "Shadowtown",
                    "Cadcide, an elite member of a militaristic cult, \nmanages to slip away after their community \nis raided by authorities. Now a fugitive, \nhe becomes a detective in the shadiest part of town.",
                    true,
                    "Sim Salabim"),
            new Book(10,
                    "978-1-623-83939-7",
                    "A List Of Blender Shortcuts",
                    "This is a thorough list of all the shortcuts used \nin the free 3D modeling software, Blender. \nSomehow, the developers of blender made so \nmay shortcuts that it takes 300 pages to list them.",
                    false),
            new Book(11,
                    "978-1-902-56782-4",
                    "Psycho Angels",
                    "When three angels are banished from heaven, \nthey go CRAZY! Watch as these fallen guardians as \nthey make their way back to the pearly gates, \ngunning down all who stand in their way!",
                    false),
            new Book(12,
                    "978-1-578-52763-5",
                    "The Red Strings Of Fate's Puppet",
                    "One day, a puppet with red strings wanders \nout from their creator's humble abode. \nTurns out, they have an innate ability to be a matchmaker! \nWill this puppet get two soulmates together?",
                    false),
            new Book(13,
                    "978-1-639-04874-8",
                    "The Barterer",
                    "One day, you wake up in a strange land, \nlosing all of your memories in the process. \nWander through the land of Polyphyl and talk to people \nas you gain your memories back.",
                    true,
                    "Alfonso Rye"),
            new Book(14,
                    "978-1-798-73893-5",
                    "The Lore Of Five Nights At Freddy's",
                    "This is a brilliant retrospective on the lore of \nFive Nights At Freddy's. Not only does \nthis book cover the lore in all of the games, \nbut it also covers fan theories.",
                    false),
            new Book(15,
                    "978-1-035-72829-3",
                    "I Dream Of Jinni",
                    "A girl with a wish and a dream has a chance \nencounter with a genie named Jinni. \nWill her wishes and dreams be granted, \nor will they fail to come to fruition?",
                    false),
            new Book(16,
                    "978-1-274-82190-0",
                    "The Dead Stare In My Bathroom",
                    "As the clock ticks, the eyes continue to stare. \nThree months ago, they have invaded this room. \nWhere did they come from? \nWhat did I do to deserve this?",
                    false),
            new Book(17,
                    "978-1-473-09292-8",
                    "My Life As a Web Developer",
                    "Want to know how I became successful in \nthe wonderful field of web dev? \nWell, scratch that record and freeze that frame, \nbecause I'll tell you how I started off!",
                    true,
                    "Alexandra Labaisse"),
            new Book(18,
                    "978-1-829-09280-2",
                    "Kindergarten Cop 2",
                    "This was a movie that somehow became a book. \nThe direct to video goodness is still intact, \nbeginning to end! Watch as two \nkindergarteners arrest grown-ups.",
                    false),
            new Book(19,
                    "978-1-763-53840-9",
                    "The Last Dance",
                    "As a loving couple is threatened by the hands \nof fate, they dance for one last time. \nWill this be their last breath as well?",
                    false)

    };

    //loops through all available books and checks if they're checked in or not
    //takes in a boolean so that the program can only display books that are checked in or checked out, respectively
    public void loopBooks(boolean bookStatus){

        boolean checkedOut = true;

        for(Book book : inventoryOfBooks){

                if (book.isCheckedOut() != checkedOut && !bookStatus){

                    System.out.println(book.getId() + " | " + book.getTitle());

                }else if (book.isCheckedOut() == checkedOut && bookStatus){

                    System.out.println(book.getId() + " | " + book.getTitle() + " | Checked out by: " + book.getCheckedOutTo());

                }


        }

    }

    //enables user to view the description of an available book based on user's integer (bookId) input
    //also enables user to go back to the home screen by typing 100
    public void viewAvailableBookDescription(){

        boolean checkedOut = false;

        for(Book ignored : inventoryOfBooks){

            Scanner userInput = new Scanner(System.in);

            System.out.println("\nSo...do you want to take a closer look at one of our fine entries? \n(Hint: Enter the book ID to view the book description, or type in 100 to go back to the home screen!)");

            int bookDescriptInput = userInput.nextInt();

                if (bookDescriptInput >= 0 && bookDescriptInput < inventoryOfBooks.length && inventoryOfBooks[bookDescriptInput].isCheckedOut() == checkedOut){

                    System.out.println("ID: " + inventoryOfBooks[bookDescriptInput].getId() + " | Title: " + inventoryOfBooks[bookDescriptInput].getTitle() + " | ISBN: " + inventoryOfBooks[bookDescriptInput].getIsbn() + " \n" + inventoryOfBooks[bookDescriptInput].getDescription());
                    break;

                }else if (bookDescriptInput == 100){

                    homeScreen(true);
                    break;

                }else{

                    System.out.println("That's not an option, buddy, so try again!");
                    availableBooksScreen(true);
                    break;

                }

        }

    }

    //enables a user to check out a book by entering their name and the book's id
    //returns error message if book id is invalid
    public void checkOutBook(){

        boolean checkedOut = true;

        for(Book ignored: inventoryOfBooks){

            Scanner userInput = new Scanner(System.in);

            System.out.println("Enter your name and the ID of the book you want to check out:");

            String userName = userInput.nextLine();

            int bookIdInput = userInput.nextInt();
            userInput.nextLine();

            if (bookIdInput >= 0 && bookIdInput < inventoryOfBooks.length && inventoryOfBooks[bookIdInput].isCheckedOut() != checkedOut) {

                System.out.println("Check out this book? (Y)es/(N)o");

                String checkOutBookInput = userInput.nextLine();

                switch (checkOutBookInput.toUpperCase()) {
                    case "Y":
                        inventoryOfBooks[bookIdInput].setCheckedOut(true);
                        inventoryOfBooks[bookIdInput].setCheckedOutTo(userName);
                        System.out.println("Nice! You, " + userName + ", checked out that book!");
                        homeScreen(true);
                        break;
                    case "N":
                        availableBooksScreen(true);
                        break;
                    default:
                        System.out.println("That's not an option, buddy, so try again!");
                        availableBooksScreen(true);
                        break;
                }
            }else{
                System.out.println("Whoops, that book is already checked out, or it doesn't exist!");
                availableBooksScreen(true);
                break;
            }

        }
    }

    //enables user to check in a checked out book by entering a book's given id
    //returns error message if book id is invalid
    public void checkInBook(){

        boolean checkedOut = true;

        for(Book ignored : inventoryOfBooks){

            Scanner userInput = new Scanner(System.in);

            System.out.println("\nEnter the ID of the book you want to check in, or type 100 to go back to all checked out books:");

            int checkedOutBookInput = userInput.nextInt();
            userInput.nextLine();

            if (checkedOutBookInput >= 0 && checkedOutBookInput < inventoryOfBooks.length && inventoryOfBooks[checkedOutBookInput].isCheckedOut() == checkedOut){

                System.out.println("ID: " + inventoryOfBooks[checkedOutBookInput].getId() + " Title: " + inventoryOfBooks[checkedOutBookInput].getTitle() + " ISBN: " + inventoryOfBooks[checkedOutBookInput].getIsbn() + " \n" + inventoryOfBooks[checkedOutBookInput].getDescription());
                System.out.println("\nCheck in this book? (Y)es/(N)o");

                String confirmInput = userInput.nextLine();

                switch (confirmInput.toUpperCase()){
                    case "Y":
                        inventoryOfBooks[checkedOutBookInput].setCheckedOut(false);
                        System.out.println("Nice! You checked in that book!");
                        homeScreen(true);
                        break;
                    case "N":
                        checkedOutBooksScreen(true);
                        break;
                    default:
                        System.out.println("That's not an option, buddy, so try again!");
                        checkedOutBooksScreen(true);

                }

                break;

            }else if (checkedOutBookInput == 100){

                checkedOutBooksScreen(true);
                break;

            }else{

                System.out.println("Whoops, that book is already checked in, or it doesn't exist!");
                checkedOutBooksScreen(true);
                break;

            }

        }

    }

    //displays the home screen
    //takes in a boolean for easier startup and navigation between screens
    public void homeScreen(boolean isEnabled){

        while (isEnabled) {

            Scanner userInput = new Scanner(System.in);

            System.out.println(" \n--------------Home Screen---------------");
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

    //displays all available books
    //takes in a boolean for easier navigation between screens
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
                    checkOutBook();
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

    //displays all checked out books
    //takes in a boolean for easier navigation between screens
    public void checkedOutBooksScreen(boolean isEnabled){

        while (isEnabled) {

            System.out.println(" \n--------------Checked Out Books---------------");

            loopBooks(true);

            System.out.println("""
                    
                    So, what do you want to do?
                    ------------------------------------
                    C) Check In Book
                    L) Take Me Back To The List!
                    X) Take Me Back To The Homepage!
                    """);

            Scanner userInput = new Scanner(System.in);

            String checkedOutBooksInput = userInput.nextLine();

            switch (checkedOutBooksInput.toUpperCase()){
                case "C":
                    checkInBook();
                    break;
                case "L":
                    checkedOutBooksScreen(true);
                    break;
                case "X":
                    homeScreen(true);
                    break;
                default:
                    System.out.println("That's not an option, buddy, so try again!");
                    checkedOutBooksScreen(true);
            }

            isEnabled = false;

        }

    }

}
