package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Genres;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class GenresRepoTest {
@Mock
GenresRepo genresRepo;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByGenreName() {
        String genreName = "Fantasy";
        Genres expectedGenre = new Genres();
        // Stubbing the method call
        when(genresRepo.findByGenreName(genreName)).thenReturn(expectedGenre);

        // When
        Genres actualGenre = genresRepo.findByGenreName(genreName);

        // Then
        assertEquals(expectedGenre, actualGenre);

    }
}