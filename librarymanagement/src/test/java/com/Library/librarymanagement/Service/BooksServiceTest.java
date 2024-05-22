package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.BooksRepo;
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

class BooksServiceTest
{
    @Mock
    BooksRepo booksRepo;
    @InjectMocks
    BooksService booksService;


     Genres genres = new Genres("UUID.randomUUID()","Fiction");
     Authors authors = new Authors("UUID.randomUUID()","John");
    Publisher publisher = new Publisher("UUID.randomUUID()","hello");
     BookAuthors bookAuthors = new BookAuthors();
     Books book2  = new Books();
     @BeforeEach
    void setUp()
    {

       book2.setBookId("UUID.randomUUID()");
       book2.setTitle("hii");
       book2.setAuthor(authors);
       book2.setIsbn("123456765");
       book2.setGenres(genres);
       book2.setPublicationYear(2045);
       book2.setQuantity(129);
       book2.setPublisher(publisher);
       bookAuthors.setAuthors(authors);
       bookAuthors.setBooks(book2);
       book2.setBookAuthors(bookAuthors);
    }
    @Test
    void addBooks()
    {
        when(booksRepo.save(book2)).thenReturn(book2);
        Books result = booksService.addBooks(book2);
        assertEquals(book2,result);

    }

    @Test
    void getBooksByGenre()
    {
        List<Books> books = new ArrayList<>();
        books.add(book2);
        String genre = "Fiction";
        when(booksRepo.findByGenresGenreName(genre)).thenReturn(books);
        List<Books> result = booksService.getBooksByGenre(genre);
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
    {   List<Books> books = new ArrayList<>();
        books.add(book2);
        String title = "hii";
        when(booksRepo.findByTitle(title)).thenReturn(books);
        List<Books> result = booksService.getBooksByTitle(title);
        assertEquals(books.size(),result.size());
        for(int i =0;i<books.size();i++)
        {
            assertEquals(books.get(i).getBookId(),result.get(i).getBookId());
            //assertEquals(books.get(i).getTitle(),result.get(i).getTitle());
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
    void getBooksBypublicationYear()
    {
        List<Books> books = new ArrayList<>();
        books.add(book2);
        int publicationYear = 2045;
        when(booksRepo.findByPublicationYear(publicationYear)).thenReturn(books);
        List<Books> result = booksService.getBooksBypublicationYear(publicationYear);
        assertEquals(books.size(),result.size());
        for(int i =0;i<books.size();i++)
        {
            assertEquals(books.get(i).getBookId(),result.get(i).getBookId());
            assertEquals(books.get(i).getTitle(),result.get(i).getTitle());
            assertEquals(books.get(i).getAuthor(),result.get(i).getAuthor());
            assertEquals(books.get(i).getIsbn(),result.get(i).getIsbn());
            assertEquals(books.get(i).getGenres(),result.get(i).getGenres());
           // assertEquals(books.get(i).getPublicationYear(),result.get(i).getPublicationYear());
            assertEquals(books.get(i).getQuantity(),result.get(i).getQuantity());
            assertEquals(books.get(i).getPublisher(),result.get(i).getPublisher());
            assertEquals(books.get(i).getBookAuthors(),result.get(i).getBookAuthors());
        }
    }
    @Test
    void getBooksByPublisher()
    {
        List<Books> books = new ArrayList<>();
        books.add(book2);
        String publisherName = "hello";
        when(booksRepo.findByPublisherPublisherName(publisherName)).thenReturn(books);
        List<Books> result = booksService.getBooksByPublisher(publisherName);
        assertEquals(books.size(),result.size());
        for(int i =0;i<books.size();i++)
        {
            assertEquals(books.get(i).getBookId(),result.get(i).getBookId());
            assertEquals(books.get(i).getTitle(),result.get(i).getTitle());
            assertEquals(books.get(i).getAuthor(),result.get(i).getAuthor());
            assertEquals(books.get(i).getIsbn(),result.get(i).getIsbn());
            assertEquals(books.get(i).getGenres(),result.get(i).getGenres());
            assertEquals(books.get(i).getPublicationYear(),result.get(i).getPublicationYear());
            assertEquals(books.get(i).getQuantity(),result.get(i).getQuantity());
           // assertEquals(books.get(i).getPublisher(),result.get(i).getPublisher());
            assertEquals(books.get(i).getBookAuthors(),result.get(i).getBookAuthors());
        }
    }
    @Test
    void getBooksByAuthor()
    {   List<Books> books = new ArrayList<>();
        books.add(book2);
        String authorName = "john";
        when(booksRepo.findByAuthorAuthorName(authorName)).thenReturn(books);
        List<Books> result = booksService.getBooksByAuthor(authorName);
        assertEquals(books,result);
        assertEquals(books.size(),result.size());
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
           // assertEquals(books.get(i).getBookAuthors(),result.get(i).getBookAuthors());
        }


    }
}