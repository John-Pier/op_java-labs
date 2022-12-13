package models;

import java.util.List;

public abstract class Library {
    String name;
    String email;

    abstract User getAdmin();
    abstract List<Book> getAllBooks();
    abstract List<Collections> getAllCollections();
    abstract List<User> getAllUsers();
}
