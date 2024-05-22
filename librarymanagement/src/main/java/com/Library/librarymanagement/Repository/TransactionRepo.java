package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Books;
import com.Library.librarymanagement.entity.Members;
import com.Library.librarymanagement.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepo extends JpaRepository<Transactions,String>
{
    List<Transactions> findByBookBookId(String bookId);

    List<Transactions> findByMembersMemberId(String memberId);

    List<Transactions> findListByMembersMemberIdAndBookBookId(String memberId, String bookId);

    Optional<Transactions> findByMembersAndBook(Members m, Books b);
}
