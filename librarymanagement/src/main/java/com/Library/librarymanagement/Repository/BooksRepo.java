

package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepo extends JpaRepository<Books, String> {
    List<Books> findByGenresGenreName(String genreName);


    List<Books> findByTitle(String title);

    List<Books> findByPublicationYear(int publicationYear);

    List<Books> findByPublisherPublisherName(String publisherName);

    List<Books> findByAuthorAuthorName(String authorName);
    Optional<Books> findById(String bookId);




}
