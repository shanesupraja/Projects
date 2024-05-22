package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.AuthorsRepo;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorsServiceTest {
    @Mock
    AuthorsRepo authorsRepo;
    @InjectMocks
    AuthorsService authorsService;



    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAuthor()
    {
        Authors author = new Authors();
        author.setAuthorId("UUID.randomUUID()");
        author.setAuthorName("hello");
        when(authorsRepo.save(author)).thenReturn(author);
        Authors result = authorsService.addAuthor(author);
        assertEquals(author,result);
    }

    @Test
    void getAllAuthors()
    {
        List<Authors> expectedAuthors = new ArrayList<>();
        expectedAuthors.add(new Authors("UUID.randomUUID()","hello"));
        expectedAuthors.add(new Authors("UUID.randomUUID()","hii"));
        when(authorsRepo.findAll()).thenReturn(expectedAuthors);
        List<Authors> result = authorsService.getAllAuthors();
        assertEquals(expectedAuthors,result);

    }


    @Test
    void testGetAuthorById_ExistingId() {

        String id = "UUID.randomUUID()";
        Authors expectedAuthor = new Authors();
        expectedAuthor.setAuthorName("John Doe");
        when(authorsRepo.findById(id)).thenReturn(Optional.of(expectedAuthor));
        String authorName = authorsService.getAuthorById(id);
        assertEquals("John Doe", authorName);
    }

    @Test
    void testGetAuthorById_NonExistingId() {

        String id = "UUID.randomUUID()";
        when(authorsRepo.findById(id)).thenReturn(Optional.empty());
        String authorName = authorsService.getAuthorById(id);
        assertEquals(null, authorName);
    }
}

