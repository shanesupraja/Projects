package com.Library.librarymanagement.controller;

import com.Library.librarymanagement.Service.TransactionService;
import com.Library.librarymanagement.entity.Books;
import com.Library.librarymanagement.entity.Members;
import com.Library.librarymanagement.entity.TransactionCreation;
import com.Library.librarymanagement.entity.TransactionDetails;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class TransactionController
{
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions/borrrow")
    public String borrowBook(@RequestBody TransactionCreation transactionCreation)
    {
        String response = transactionService.borrowBook(transactionCreation);
        return  response;
    }


    @PostMapping("/transactions/return")
    public String returnBook(@RequestBody TransactionCreation transactionCreation) {
        String response = transactionService.returnBook(transactionCreation);
        return response;
    }
    @GetMapping("/transactions/all")
    public List<TransactionDetails> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/member/{memberId}")
    public List<TransactionDetails> getTransactionByMemberId(@PathVariable("memberId") String memberId)
    {
        return transactionService.getTransactionByMemberId(memberId);
    }
    @GetMapping("/transactions/book/{bookId}")
    public List<TransactionDetails> getTransactionByBookId(@PathVariable("bookId") String bookId) {
        return  transactionService.getTransactionByBookId(bookId);
    }
    @GetMapping("/transactions/member-book/{memberId}/{bookId}")
    public List<TransactionDetails> getTransactionByMemberAndBook(
            @PathVariable("memberId") String memberId, @PathVariable("bookId") String bookId) {
        return transactionService.getTransactionByMemberIdAndBookId(memberId, bookId);
    }




}
