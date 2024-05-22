package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.PublisherRepo;
import com.Library.librarymanagement.entity.Authors;
import com.Library.librarymanagement.entity.Publisher;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class PublisherServiceTest {
    @Mock
    PublisherRepo publisherRepo;
    @InjectMocks
    PublisherService publisherService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPublisher()
    {
        Publisher publisher = new Publisher("UUID.randomUUID()","hello");
        when(publisherRepo.save(publisher)).thenReturn(publisher);
        Publisher result = publisherService.addPublisher(publisher);
        assertEquals(publisher,result);

    }

    @Test
    void getAllPublisher()
    {
        List<Publisher> expected = new ArrayList<>();
        expected.add(new Publisher("1","hii"));
        expected.add(new Publisher("2","hello"));
        when(publisherRepo.findAll()).thenReturn(expected);
        List<Publisher> result = publisherService.getAllPublisher();
        assertEquals(expected,result);
    }

    @Test
    void testGetPublisherById_ExistingId() {

        String id = "UUID.randomUUID()";
        Publisher expectedPublisher = new Publisher();
       expectedPublisher.setPublisherName("John Doe");
        when(publisherRepo.findById(id)).thenReturn(Optional.of(expectedPublisher));
        String result =publisherService.getPublisherById(id);
        assertEquals("John Doe", result);
    }

    @Test
    void testGetAuthorById_NonExistingId() {

        String id = "UUID.randomUUID()";
        when(publisherRepo.findById(id)).thenReturn(Optional.empty());
        String authorName = publisherService.getPublisherById(id);
        assertEquals(null, authorName);
    }
}