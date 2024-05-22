package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Repository.PublisherRepo;
import com.Library.librarymanagement.Service.PublisherService;
import com.Library.librarymanagement.entity.Authors;
import com.Library.librarymanagement.entity.Publisher;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PublishersController
{
    @Autowired

   PublisherService publisherService;
    @PostMapping("/postPublisher")
    public Publisher addPublisher(@RequestBody  Publisher publisher)
    {
        return publisherService.addPublisher(publisher);

    }
    @Hidden

    @GetMapping("/allPublisher")
    public List<Publisher> getAllPublisher()
    {
        return publisherService.getAllPublisher();
    }

    @GetMapping("/PublisherName/{id}")
    public String getPublisherById(@PathVariable String id)
    {
        return publisherService.getPublisherById(id);
    }


}
