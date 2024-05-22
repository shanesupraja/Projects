package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.PublisherRepo;
import com.Library.librarymanagement.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PublisherService {
    @Autowired
    PublisherRepo publisherRepo;

    public Publisher addPublisher(Publisher publisher) {
       return publisherRepo.save(publisher);
    }

    public List<Publisher> getAllPublisher() {
        return publisherRepo.findAll();
    }


    public String getPublisherById(String id) {
        Publisher publisher = publisherRepo.findById(String.valueOf(id)).orElse(null);
        if (publisher != null) {
            return publisher.getPublisherName();
        } else {
            return null;
        }
    }
}

