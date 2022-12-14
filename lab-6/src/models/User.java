package models;

public abstract class User {
    String fio;
    String id;
    String role;
    String[] readBooksIds;

    abstract Review getReviews();
}
