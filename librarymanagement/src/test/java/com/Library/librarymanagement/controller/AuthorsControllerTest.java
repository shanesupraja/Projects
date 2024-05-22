package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.AuthorsService;
import com.Library.librarymanagement.entity.Authors;
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

class AuthorsControllerTest
{
    @Mock
    AuthorsService authorsService;
    @InjectMocks
    AuthorsController authorsController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAuthor()
    {
        Authors author = new Authors();
        when(authorsService.addAuthor(author)).thenReturn(author);
        Authors result = authorsController.addAuthor(author);
        assertEquals(author,result);
    }

    @Test
    void getAllAuthors() {
        List<Authors> authorsList = new ArrayList<>();
        authorsList.add(new Authors("1", "Author1"));
        authorsList.add(new Authors("2", "Author2"));
        authorsList.add(new Authors("3", "Author3"));
        when(authorsService.getAllAuthors()).thenReturn(authorsList);
        List<Authors> result = authorsController.getAllAuthors();
        assertEquals(authorsList, result);
    }

    @Test
    void getAuthorById()
    {
        String id = "UUID.randomUUID()";
        String authorName = "author1";
        when(authorsService.getAuthorById(id)).thenReturn(authorName);
        String result = authorsController.getAuthorById(id);
        assertEquals(authorName,result);
    }
}