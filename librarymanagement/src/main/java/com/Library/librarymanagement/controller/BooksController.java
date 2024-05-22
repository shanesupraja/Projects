package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.BooksService;
import com.Library.librarymanagement.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController
{
    @Autowired
    BooksService booksService;

    @PostMapping("/addBooks")
    public Books addBooks( @RequestBody  Books books)
    {
       return  booksService.addBooks(books);
    }
    @GetMapping("/byGenre/{genreName}")
    public List<Books> getBooksByGenre(@PathVariable  String genreName)
    {
        return booksService.getBooksByGenre(genreName);
    }
    @GetMapping("/bytitle/{title}")
    public List<Books> getBooksByTitle(@PathVariable String title)
    {
        return booksService.getBooksByTitle(title);
    }

    @GetMapping("/byyear/{publicationYear}")
    public  List<Books> getBooksBypublicationYear(@PathVariable int publicationYear)
    {
        return booksService.getBooksBypublicationYear(publicationYear);
    }

    @GetMapping("/publisher/{publisherName}")
    public List<Books> getBooksBypublisher(@PathVariable String publisherName)
    {
        return booksService.getBooksByPublisher(publisherName);
    }

    @GetMapping("/author/{authorName}")
    public List<Books> getBooksByAuthor(@PathVariable String authorName)
    {
        return booksService.getBooksByAuthor(authorName);
    }






}
