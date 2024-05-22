package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.GenresRepo;
import com.Library.librarymanagement.entity.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GenresService
{
    @Autowired
    GenresRepo genresRepo;
    public Genres addGenres(Genres genres)
    {

        return genresRepo.save(genres);

    }
   public  List<Genres> getAllGenres()
   {
       return genresRepo.findAll();

   }

   public String getGenreById(String id)
   {
       Genres genres = genresRepo.findById(String.valueOf(id)).orElse(null);
       if (genres != null)
       {
           return genres.getGenreName();
       }
       else
       {
           return null;

       }
   }




}
