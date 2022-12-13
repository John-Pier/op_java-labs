package models;

import java.util.List;

public abstract class Author {
    String id;
    String fio;
    abstract List<Book> getAuthorBooks();
}
