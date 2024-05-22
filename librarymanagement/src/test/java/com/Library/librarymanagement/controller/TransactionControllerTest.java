package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.TransactionService;
import com.Library.librarymanagement.entity.TransactionCreation;
import com.Library.librarymanagement.entity.TransactionDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class TransactionControllerTest
{
    @Mock
    TransactionService transactionService;
    @InjectMocks
    TransactionController transactionController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void borrowBook()
    {
        TransactionCreation transactionCreation = new TransactionCreation();
        when(transactionService.borrowBook(transactionCreation)).thenReturn("Borrow transaction successfully");
        String result = transactionController.borrowBook(transactionCreation);
        assertEquals("Borrow transaction successfully",result);
    }

    @Test
    void returnBook()
    {
        TransactionCreation transactionCreation = new TransactionCreation();
        when(transactionService.returnBook(transactionCreation)).thenReturn("Book returned successfully.");
        String result = transactionController.returnBook(transactionCreation);
        assertEquals("Book returned successfully.",result);
    }

    @Test
    void getAllTransactions()
    {
        List<TransactionDetails> expected = new ArrayList<>();
        when(transactionService.getAllTransactions()).thenReturn(expected);
        List<TransactionDetails> result = transactionController.getAllTransactions();
        assertEquals(expected,result);
    }

    @Test
    void getTransactionByMemberId()
    {
       String memberId = "UUID.randomUUID()";
       List<TransactionDetails> expected = new ArrayList<>();
       when(transactionService.getTransactionByMemberId(memberId)).thenReturn(expected);
       List<TransactionDetails> result = transactionController.getTransactionByMemberId(memberId);
       assertEquals(expected,result);
    }

    @Test
    void getTransactionByBookId()
    {
        String bookId = "UUID.randomUUID()";
        List<TransactionDetails> expected = new ArrayList<>();
        when(transactionService.getTransactionByBookId(bookId)).thenReturn(expected);
        List<TransactionDetails> result = transactionController.getTransactionByBookId(bookId);
        assertEquals(expected,result);

    }

    @Test
    void getTransactionByMemberAndBook()
    {
        String memberId = "UUID.randomUUID()";
        String bookId = "UUID.randomUUID()";
        List<TransactionDetails> expected = new ArrayList<>();
        when(transactionService.getTransactionByMemberIdAndBookId(memberId,bookId)).thenReturn(expected);
        List<TransactionDetails> result = transactionController.getTransactionByMemberAndBook(memberId,bookId);
        assertEquals(expected,result);
    }
}