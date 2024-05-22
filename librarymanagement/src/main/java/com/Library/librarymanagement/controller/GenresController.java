package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.GenresService;
import com.Library.librarymanagement.entity.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class  GenresController
{
    @Autowired
    GenresService genresService;

    @PostMapping("/postGenres")
    public Genres addGenres( @RequestBody  Genres genres)
    {
       return  genresService.addGenres(genres);
    }
    @GetMapping("/allGenres")
    public List<Genres> getAllGenres()
    {
        return genresService.getAllGenres();
    }

    @GetMapping("/GenreName/{id}")
    public String getGenreById(@PathVariable String id)
    {
        return genresService.getGenreById(id);
    }
}
