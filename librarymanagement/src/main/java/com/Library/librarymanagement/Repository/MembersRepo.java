package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepo extends JpaRepository<Members,String>
{
    Optional<Members> findById(String memberId);


}
