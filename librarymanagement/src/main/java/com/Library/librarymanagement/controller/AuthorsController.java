package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.AuthorsService;
import com.Library.librarymanagement.entity.Authors;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorsController
{
    @Autowired
    AuthorsService authorsService;
    @ApiResponse(
            responseCode = "200",
            description = "Success Author added successfully"
    )

    @ApiResponse(
            responseCode = "500",
            description = "Internal Error"
    )
//    @Operation(tags = "for adding a new author to a book",
//            description = "posting an author"
//
//    )


    @PostMapping("/addauthor")
    public Authors addAuthor( @RequestBody  Authors authors)
    {
        return authorsService.addAuthor(authors);
    }

    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )

    @ApiResponse(
            responseCode = "500",
            description = "Internal Error"
    )
    @GetMapping("/all")
    public List<Authors> getAllAuthors()
    {
        return authorsService.getAllAuthors();
    }

    @ApiResponse(
            responseCode = "200",
            description = "Success"
    )

    @ApiResponse(
            responseCode = "500",
            description = "Internal Error"
    )

    @GetMapping("/AuthorName/{id}")
    public String getAuthorById(@PathVariable String id)
    {
        return authorsService.getAuthorById(id);
    }


}
