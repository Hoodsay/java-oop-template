package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

public class SimpleAuthorRepository implements AuthorRepository {

    private Author[] authors = new Author[0];

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            Author[] tempAuthor = new Author[authors.length + 1];
            System.arraycopy(authors, 0, tempAuthor, 0, authors.length);
            authors = tempAuthor;
            return true;
        }
        return false;
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
        return false;
    }

    @Override
    public int count() {
        return 0;
    }
}
