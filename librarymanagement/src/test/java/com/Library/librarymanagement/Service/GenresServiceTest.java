package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.GenresRepo;
import com.Library.librarymanagement.controller.GenresController;
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
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class GenresServiceTest {
    @Mock
    GenresRepo genresRepo;
    @InjectMocks
   GenresService genresService;
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
        genre.setGenreId("UUID.randomUUID()");
        genre.setGenreName("hello");
        when(genresRepo.save(genre)).thenReturn(genre);
        Genres result = genresService.addGenres(genre);
        assertEquals(genre,result);
    }

    @Test
    void getAllGenres()
    {
        List<Genres> expected = new ArrayList<>();
        expected.add(new Genres("1","hii"));
        expected.add(new Genres("2","hello"));
        when(genresRepo.findAll()).thenReturn(expected);
        List<Genres> result = genresService.getAllGenres();
        assertEquals(expected,result);
    }

    @Test
    void testGetGenresById_ExistingId() {

        String id = "UUID.randomUUID()";
        Genres expectedGenre = new Genres();
        expectedGenre.setGenreName("Fiction");
        when(genresRepo.findById(id)).thenReturn(Optional.of(expectedGenre));
        String authorName = genresService.getGenreById(id);
        assertEquals("Fiction", authorName);
    }

    @Test
    void testGetGenreById_NonExistingId() {

        String id = "UUID.randomUUID()";
        when(genresRepo.findById(id)).thenReturn(Optional.empty());
        String authorName = genresService.getGenreById(id);
        assertEquals(null, authorName);
    }


}