package utils;

public abstract class Controller {
    LibraryService service;

    abstract void addUser();
    abstract void addBook();
    abstract void addAuthor();
    abstract void addReview();

    // other get methods
}
