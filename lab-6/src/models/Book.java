package models;

import java.util.List;

public abstract class Book {
    String id;
    String name;
    Genre[] genres;

    abstract Author getAuthor();
    abstract List<Review> getReviews();
}
