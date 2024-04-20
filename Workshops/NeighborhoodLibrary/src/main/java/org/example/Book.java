package org.example;

//Five properties must be listed: id (int), isbn (string), title (string), isCheckedOut (boolean), checkedOutTo (string)
//To add some extra spice...bookDescription (string)
//We need four constructors:
//one that takes in all 6 parameters
//one that takes in 3 (excluding isCheckedOut, description and checkedOutTo)
//one that takes title, id, and description
//one that takes in everything except for description
//and getters and setters for each one of the 6 parameters
//also two methods:
//checkOut (name) and checkIn ()/(id perhaps?)
//checkOut: is set to the name provided in Library, and the isCheckedOut variable should be true
//remember: make this applicable to any book
//checkIn: checkedOutTo should be set to "", and isCheckedOut should be set to false

public class Book {

    private int id;
    private String isbn;
    private String title;
    private String description;
    private boolean isCheckedOut;
    private String checkedOutTo;

    //used to show available books
    public Book(int id, String isbn, String title, String description, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = "";
    }

    //used to show checked out books
    public Book(int id, String isbn, String title, String description, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean isCheckedOut) {this.isCheckedOut = isCheckedOut;}

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

}
