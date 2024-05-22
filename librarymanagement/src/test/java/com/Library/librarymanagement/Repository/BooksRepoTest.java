package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Books;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class BooksRepoTest {
    @Mock
    BooksRepo booksRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByGenresGenreName() {
        String genreName = "Fantasy";
        List<Books> expectedBooks = new ArrayList<>();
        when(booksRepo.findByGenresGenreName(genreName)).thenReturn(expectedBooks);
        List<Books> actualBooks = booksRepo.findByGenresGenreName(genreName);
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void findByTitle() {
        String title = "Harry Potter";
        List<Books> expectedBooks = new ArrayList<>();
        // Add some books to the expected list
        // Stubbing the method call
        when(booksRepo.findByTitle(title)).thenReturn(expectedBooks);

        // When
        List<Books> actualBooks = booksRepo.findByTitle(title);

        // Then
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void findByPublicationYear() {
        int publicationYear = 2020;
        List<Books> expectedBooks = new ArrayList<>();
        // Add some books to the expected list
        // Stubbing the method call
        when(booksRepo.findByPublicationYear(publicationYear)).thenReturn(expectedBooks);

        // When
        List<Books> actualBooks = booksRepo.findByPublicationYear(publicationYear);

        // Then
        assertEquals(expectedBooks, actualBooks);

    }

    @Test
    void findByPublisherPublisherName() {
        String publisherName = "PublisherXYZ";
        List<Books> expectedBooks = new ArrayList<>();
        // Add some books to the expected list
        // Stubbing the method call
        when(booksRepo.findByPublisherPublisherName(publisherName)).thenReturn(expectedBooks);

        // When
        List<Books> actualBooks = booksRepo.findByPublisherPublisherName(publisherName);

        // Then
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void findByAuthorAuthorName() {
        String authorName = "J.K. Rowling";
        List<Books> expectedBooks = new ArrayList<>();
        // Add some books to the expected list
        // Stubbing the method call
        when(booksRepo.findByAuthorAuthorName(authorName)).thenReturn(expectedBooks);

        // When
        List<Books> actualBooks = booksRepo.findByAuthorAuthorName(authorName);

        // Then
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void findById() {
        String bookId = "123";
        Optional<Books> expectedBook = Optional.of(new Books());
        // Stubbing the method call
        when(booksRepo.findById(bookId)).thenReturn(expectedBook);

        // When
        Optional<Books> actualBook = booksRepo.findById(bookId);

        // Then
        assertEquals(expectedBook, actualBook);
    }
}