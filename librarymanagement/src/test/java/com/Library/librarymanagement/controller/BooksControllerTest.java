package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.BooksService;
import com.Library.librarymanagement.entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class BooksControllerTest
{
    @Mock
    BooksService booksService;

    @InjectMocks
    BooksController booksController;
    private  Genres genres;
    private Authors authors;
    private Publisher publisher;
    private BookAuthors bookAuthors;
    List<Books> books ;
    @BeforeEach
    void setUp()
    {

         authors = new Authors("UUID.randomUUID()","John");
         genres = new Genres("UUID.randomUUID()","Fiction");
         publisher =  new Publisher("UUID.randomUUID()","hello");
         bookAuthors = new BookAuthors();
         bookAuthors.setAuthors(authors);
         books = new ArrayList<>();
         Books book1 =   new Books("UUID.randomUUID()","Book1",authors,"123456789",genres,2023,100,publisher,bookAuthors);
         books.add(book1);
         bookAuthors.setBooks(book1);
    }
    @Test
    void addBooks()
    {
        Books book2 = new Books();
        when(booksService.addBooks(book2)).thenReturn(book2);
        Books result = booksController.addBooks(book2);
        assertEquals(book2,result);

    }

    @Test
    void getBooksByGenre() {
        String genre = "Fiction";
        when(booksService.getBooksByGenre(genre)).thenReturn(books);
        List<Books> result = booksController.getBooksByGenre("Fiction");
        // assertEquals(books,result);
        assertEquals(books.size(), result.size());
        for(int i =0;i<books.size();i++)
        {
            assertEquals(books.get(i).getBookId(),result.get(i).getBookId());
            assertEquals(books.get(i).getTitle(),result.get(i).getTitle());
            assertEquals(books.get(i).getAuthor(),result.get(i).getAuthor());
            assertEquals(books.get(i).getIsbn(),result.get(i).getIsbn());
            assertEquals(books.get(i).getGenres(),result.get(i).getGenres());
            assertEquals(books.get(i).getPublicationYear(),result.get(i).getPublicationYear());
            assertEquals(books.get(i).getQuantity(),result.get(i).getQuantity());
            assertEquals(books.get(i).getPublisher(),result.get(i).getPublisher());
            assertEquals(books.get(i).getBookAuthors(),result.get(i).getBookAuthors());
        }
    }
    @Test
    void getBooksByTitle()
    {
        String title = "Book1";
        when(booksService.getBooksByTitle(title)).thenReturn(books);
        List<Books> result = booksController.getBooksByTitle(title);
        assertEquals(books,result);

    }

    @Test
    void getBooksBypublicationYear()
    {
        int publicationYear = 1996;
        when(booksService.getBooksBypublicationYear(publicationYear)).thenReturn(books);
        List<Books> result = booksController.getBooksBypublicationYear(publicationYear);
        assertEquals(books,result);
    }

    @Test
    void getBooksBypublisher()
    {
        String publisherName = "hello";
        when(booksService.getBooksByPublisher(publisherName)).thenReturn(books);
        List<Books> result = booksController.getBooksBypublisher(publisherName);
        assertEquals(books,result);
    }
    @Test
  void   getBooksByAuthor()
    {
        String authorName = "John";
        when(booksService.getBooksByAuthor(authorName)).thenReturn(books);
        List<Books> result = booksController.getBooksByAuthor(authorName);
        assertEquals(books,result);

    }
}