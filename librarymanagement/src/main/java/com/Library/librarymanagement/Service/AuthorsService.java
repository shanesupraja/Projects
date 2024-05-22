package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.AuthorsRepo;
import com.Library.librarymanagement.entity.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorsService
{
    @Autowired
    AuthorsRepo authorsRepo;
    public Authors addAuthor(Authors author)
    {

        return authorsRepo.save(author);
    }

    public List<Authors> getAllAuthors()
    {
        return authorsRepo.findAll();
    }

    public String getAuthorById(String id)
    {
        Authors authors = authorsRepo.findById(String.valueOf(id)).orElse(null);
        if(authors != null)
        {
            return authors.getAuthorName();
        }
        else
        {
            return null;
        }
    }

}
