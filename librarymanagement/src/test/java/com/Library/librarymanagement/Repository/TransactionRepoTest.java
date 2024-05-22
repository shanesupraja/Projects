package com.Library.librarymanagement.Repository;

import com.Library.librarymanagement.entity.Books;
import com.Library.librarymanagement.entity.Members;
import com.Library.librarymanagement.entity.Transactions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class TransactionRepoTest {
    @Mock
    TransactionRepo transactionRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByBookBookId() {
        String bookId = "1";
        Transactions transaction1 = new Transactions();
        Transactions transaction2 = new Transactions();
        List<Transactions> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        // Stubbing the repository method
        when(transactionRepo.findByBookBookId(bookId)).thenReturn(transactions);

        // Call the method being tested
        List<Transactions> result = transactionRepo.findByBookBookId(bookId);

        // Verify the result
        assertEquals(transactions.size(), result.size());
    }

    @Test
    void findByMembersMemberId() {
        String memberId = "1";
        Transactions transaction1 = new Transactions();
        Transactions transaction2 = new Transactions();
        List<Transactions> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        // Stubbing the repository method
        when(transactionRepo.findByMembersMemberId(memberId)).thenReturn(transactions);

        // Call the method being tested
        List<Transactions> result = transactionRepo.findByMembersMemberId(memberId);

        // Verify the result
        assertEquals(transactions.size(), result.size());
    }

    @Test
    void findListByMembersMemberIdAndBookBookId() {
        String memberId = "1";
        String bookId = "1";
        Transactions transaction1 = new Transactions();
        Transactions transaction2 = new Transactions();
        List<Transactions> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        // Stubbing the repository method
        when(transactionRepo.findListByMembersMemberIdAndBookBookId(memberId, bookId)).thenReturn(transactions);

        // Call the method being tested
        List<Transactions> result = transactionRepo.findListByMembersMemberIdAndBookBookId(memberId, bookId);

        // Verify the result
        assertEquals(transactions.size(), result.size());

    }

    @Test
    void findByMembersAndBook() {
        Members member = new Members();
        member.setMemberId("1");
        Books book = new Books();
        book.setBookId("1");
        Transactions transaction = new Transactions();
        transaction.setMembers(member);
        transaction.setBook(book);

        // Stubbing the repository method
        when(transactionRepo.findByMembersAndBook(member, book)).thenReturn(Optional.of(transaction));

        // Call the method being tested
        Optional<Transactions> result = transactionRepo.findByMembersAndBook(member, book);

        // Verify the result
        assertEquals(transaction, result.get());
    }
}