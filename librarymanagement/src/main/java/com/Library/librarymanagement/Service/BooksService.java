package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.AuthorsRepo;
import com.Library.librarymanagement.Repository.BooksRepo;
import com.Library.librarymanagement.Repository.GenresRepo;
import com.Library.librarymanagement.Repository.PublisherRepo;

import com.Library.librarymanagement.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BooksService {
    @Autowired
    AuthorsRepo authorsRepo;

    @Autowired
    BooksRepo booksRepo;
    @Autowired
    GenresRepo genresRepo;
    @Autowired
    PublisherRepo publisherRepo;

    public Books addBooks(Books books)
    {
        return booksRepo.save(books);

    }

    public List<Books> getBooksByGenre(String genreName)
    {
        return booksRepo.findByGenresGenreName(genreName);
    }

    public List<Books> getBooksByTitle(String title)
    {
        return booksRepo.findByTitle(title);
    }

    public List<Books> getBooksBypublicationYear(int publicationYear)
    {
        return booksRepo.findByPublicationYear(publicationYear);
    }

    public List<Books> getBooksByPublisher(String publisherName)
    {
        return booksRepo.findByPublisherPublisherName(publisherName);
    }




    public List<Books> getBooksByAuthor(String authorName)
    {
        return booksRepo.findByAuthorAuthorName(authorName);
    }
}

