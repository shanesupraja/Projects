package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.GenresService;
import com.Library.librarymanagement.entity.Authors;
import com.Library.librarymanagement.entity.Genres;
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
class GenresControllerTest {
    @Mock
    GenresService genresService;
    @InjectMocks
    GenresController genresController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addGenres()
    {
       Genres genre = new Genres();
        when(genresService.addGenres(genre)).thenReturn(genre);
       Genres result = genresController.addGenres(genre);
        assertEquals(genre,result);
    }

    @Test
    void getAllGenres()
    {

        List<Genres>  genresList = new ArrayList<>();
        genresList.add(new Genres("1","genre1"));
        genresList.add(new Genres("2","genre2"));
        when(genresService.getAllGenres()).thenReturn(genresList);
        List<Genres> result = genresController.getAllGenres();
        assertEquals(genresList,result);
    }

    @Test
    void getGenreById()
    {
        String id = "UUID.randomUUID()";
        String genreName = "genre1";
        when(genresService.getGenreById(id)).thenReturn(genreName);
        String result = genresController.getGenreById(id);
        assertEquals(genreName,result);
    }
}