package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        Author[] tempAuthor = new Author[authors.length];
        System.arraycopy(authors, 0, tempAuthor, 0, authors.length);
        authors = new Author[authors.length + 1];
        System.arraycopy(tempAuthor, 0, authors, 0, tempAuthor.length);
        authors[authors.length - 1] = author;
        return true;
    }

    @Override
    public Author findByFullName(String name, String lastName) {
        for (Author author: authors) {
            if (author.getName().equalsIgnoreCase(name) && author.getLastName().equalsIgnoreCase(lastName)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        Author[] tempAuthor = new Author[authors.length];
        System.arraycopy(authors, 0, tempAuthor, 0, authors.length);
        authors = new Author[authors.length - 1];
        for (Author authorGiven: tempAuthor) {
            int i = 0;
            if (!(author.getName().equalsIgnoreCase(authorGiven.getName()) && author.getLastName().equalsIgnoreCase(authorGiven.getLastName()))) {
                authors[i] = authorGiven;
                i++;
            }
        }
        return true;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
