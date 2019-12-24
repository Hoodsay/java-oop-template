package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository <SchoolBook> {

    private SchoolBook[] schoolBooks = new SchoolBook[0];

    @Override
    public boolean save(SchoolBook book) {
        SchoolBook[] tempSchoolBook = new SchoolBook[schoolBooks.length];
        System.arraycopy(schoolBooks, 0, tempSchoolBook, 0, schoolBooks.length);
        schoolBooks = new SchoolBook[schoolBooks.length + 1];
        System.arraycopy(tempSchoolBook, 0, schoolBooks, 0, tempSchoolBook.length);
        schoolBooks[schoolBooks.length - 1] = book;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] fondedBooks = new SchoolBook[0];
        for(SchoolBook givenSchoolBook: schoolBooks) {
            int i = 0;
            if(name.equalsIgnoreCase(givenSchoolBook.getName()) == true) {
                fondedBooks = new SchoolBook[fondedBooks.length + 1];
                fondedBooks[i] = givenSchoolBook;
                i++;
            }
        }
        return fondedBooks;
    }

    @Override
    public boolean removeByName(String name) {
        int numberToRemove = findByName(name).length;
        if (numberToRemove != 0) {
            SchoolBook[] tempSchoolBook2 = new SchoolBook[schoolBooks.length - numberToRemove];
            int i =0;
            for (SchoolBook bookGiven: schoolBooks) {
                if (bookGiven.getName().equalsIgnoreCase(name) == false) {
                    tempSchoolBook2[i] = bookGiven;
                    i++;
                }
            }
            schoolBooks = tempSchoolBook2;
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
