package models;

import java.util.List;

public abstract class LibraryDescription {
    String name;
    String email;

    abstract List<User> getAdmins();
}
