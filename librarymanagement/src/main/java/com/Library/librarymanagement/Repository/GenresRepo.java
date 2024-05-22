package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepo extends JpaRepository<Genres,String>
{
    Genres findByGenreName(String genreName);
}
