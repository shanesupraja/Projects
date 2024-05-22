package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Publisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PublisherRepoTest {
    @Mock
    PublisherRepo publisherRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByPublisherName() {
        String publisherName = "Test Publisher";
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherName);

        // Stubbing the repository method
        when(publisherRepo.findByPublisherName(publisherName)).thenReturn(publisher);

        // Call the method being tested
        Publisher result = publisherRepo.findByPublisherName(publisherName);

        // Verify the result
        assertEquals(publisherName, result.getPublisherName());
    }
}