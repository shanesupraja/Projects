package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepo extends JpaRepository<Publisher,String>
{

    Publisher findByPublisherName(String publisherName);


}
