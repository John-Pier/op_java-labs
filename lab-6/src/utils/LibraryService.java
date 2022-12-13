package utils;

import models.*;

import java.util.List;

public abstract class LibraryService {
    LibraryDescription libraryDescription;
    //other entities

    // get/select methods;
    abstract List<Book> getAllBooks();
    abstract List<Collections> getAllCollections();
    abstract List<Author> getAllAuthors();
    abstract List<User> getAllUsers();

    abstract void createUser();
    abstract void createBook();
    abstract void createAuthor();
    abstract void createReview();
}
