package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.PublisherService;
import com.Library.librarymanagement.entity.Genres;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class PublishersControllerTest
{

    @Mock
    PublisherService publisherService;

    @InjectMocks
    PublishersController publishersController;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPublisher()
    {
        Publisher publisher = new Publisher();
        when(publisherService.addPublisher(publisher)).thenReturn(publisher);
        Publisher result = publishersController.addPublisher(publisher);
        assertEquals(publisher,result);
    }

    @Test
    void getAllPublisher() {
        List<Publisher> publisherList = new ArrayList<>();
        publisherList.add(new Publisher("1","genre1"));
        publisherList.add(new Publisher("2","genre2"));
        when(publisherService.getAllPublisher()).thenReturn(publisherList);
        List<Publisher> result = publishersController.getAllPublisher();
        assertEquals(publisherList,result);
    }

    @Test
    void getPublisherById()
    {
        String id = "UUID.randomUUID()";
        String publisherName = "publisher1";
        when(publisherService.getPublisherById(id)).thenReturn(publisherName);
        String result = publishersController.getPublisherById(id);
        assertEquals(publisherName,result);
    }
}