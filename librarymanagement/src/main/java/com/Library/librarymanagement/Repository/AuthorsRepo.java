package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepo extends JpaRepository<Authors,String>
{


}
