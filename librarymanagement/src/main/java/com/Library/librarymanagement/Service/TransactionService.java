package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.BooksRepo;
import com.Library.librarymanagement.Repository.MembersRepo;
import com.Library.librarymanagement.Repository.TransactionRepo;
import com.Library.librarymanagement.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class TransactionService
{
    @Autowired
    private TransactionRepo transactionRepo;
    @Autowired
    private BooksRepo bookRepo;
    @Autowired
    private MembersRepo memberRepo;


    public String borrowBook(TransactionCreation transactionCreation)
    {
        String memberId = transactionCreation.getMemberId();
        String bookId = transactionCreation.getBookId();
        String transactionType = transactionCreation.getTransactionType();
        Members member = new Members();
        member.setMemberId(memberId);
        Books  book = new Books();
        book.setBookId(bookId);
        if(!transactionType.equalsIgnoreCase("borrow"))
        {
            return "Invalid transaction type. Must be 'borrow',";
        }
        Optional<Transactions> existingTransaction = transactionRepo.findByMembersAndBook(member,book);
        if(existingTransaction.isPresent())
        {
            return "you have already borrowed the same book";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date());
        calendar.add(Calendar.WEEK_OF_YEAR,2);
        Date dueDate = calendar.getTime();

        Optional<Books> booksOptional = bookRepo.findById(bookId);
        if(booksOptional.isEmpty())
        {
            return "book not found";
        }
        Books foundBook = booksOptional.get();
        long quantity = foundBook.getQuantity();
        if(quantity<=0)
        {
            return "book is not available";
        }
        Optional<Members> membersOptional = memberRepo.findById(memberId);
        if(membersOptional.isEmpty())
        {
            return "member not found";
        }
        Members foundMember = membersOptional.get();
        foundBook.setQuantity(quantity-1);
        Transactions transactions = new Transactions();
        transactions.setTransactionType(transactionType);
        transactions.setDueDate(dueDate);
        transactions.setReturnDate(null);
        transactions.setBook(bookRepo.save(foundBook));
        transactions.setMembers(memberRepo.save(foundMember));
        transactionRepo.save(transactions);
        return  " Borrow transaction successfully";
    }



    public String returnBook(TransactionCreation transactionCreation) {
        String memberId = transactionCreation.getMemberId();
        String bookId = transactionCreation.getBookId();
        String transactionType = transactionCreation.getTransactionType();

        if (!transactionType.equalsIgnoreCase("return")) {
            return "Invalid transaction type.";
        }

        Members member = new Members();
        member.setMemberId(memberId);

        Books book = new Books();
        book.setBookId(bookId);

        Optional<Transactions> optionalTransaction = transactionRepo.findByMembersAndBook(member, book);
        if (optionalTransaction.isEmpty()) {
            return "You have not borrowed this book.";
        }

        Transactions transaction = optionalTransaction.get();
        Books borrowedBook = transaction.getBook();
        long quantity = borrowedBook.getQuantity();
        borrowedBook.setQuantity(quantity + 1);
        Books savedBook = bookRepo.save(borrowedBook);

        Transactions newTransaction = new Transactions();
        newTransaction.setTransactionType(transactionType);
        newTransaction.setDueDate(transaction.getDueDate());
        newTransaction.setBook(savedBook);
        newTransaction.setMembers(transaction.getMembers());

        Calendar returnDateCalendar = Calendar.getInstance();
        returnDateCalendar.setTime(transaction.getDueDate());
        returnDateCalendar.add(Calendar.WEEK_OF_YEAR, 2);
        Date returnDate = returnDateCalendar.getTime();
        newTransaction.setReturnDate(returnDate);

        transactionRepo.save(newTransaction);

        return "Book returned successfully.";
    }



    public List<TransactionDetails> getAllTransactions() {
        List<Transactions> transactions = transactionRepo.findAll();
        List<TransactionDetails> transactionDetailsList = new ArrayList<>();

        for (Transactions transaction : transactions) {
            TransactionDetails details = new TransactionDetails();
            details.setTransactionId(transaction.getTransactionId());
            details.setBookId(transaction.getBook().getBookId());
            details.setMemberId(transaction.getMembers().getMemberId());
            details.setTransactionType(transaction.getTransactionType());
            details.setDueDate(transaction.getDueDate());
            details.setReturnDate(transaction.getReturnDate());

            transactionDetailsList.add(details);
        }

        return transactionDetailsList;
    }

    public List<TransactionDetails> getTransactionByMemberId(String memberId) {
        List<Transactions> transactions = transactionRepo.findByMembersMemberId(memberId);
        List<TransactionDetails> transactionDetailsList = new ArrayList<>();

        for (Transactions transaction : transactions) {
            TransactionDetails details = new TransactionDetails();
            details.setTransactionId(transaction.getTransactionId());            details.setBookId(transaction.getBook().getBookId());
            details.setMemberId(transaction.getMembers().getMemberId());
            details.setTransactionType(transaction.getTransactionType());
            details.setDueDate(transaction.getDueDate());
            details.setReturnDate(transaction.getReturnDate());

            transactionDetailsList.add(details);
        }

        return transactionDetailsList;
    }
    public List<TransactionDetails> getTransactionByBookId(String bookId) {
        List<Transactions> transactions = transactionRepo.findByBookBookId(bookId);
        List<TransactionDetails> transactionDetailsList = new ArrayList<>();

        for (Transactions transaction : transactions) {
            TransactionDetails details = new TransactionDetails();
            details.setTransactionId(transaction.getTransactionId());
            details.setBookId(transaction.getBook().getBookId());
            details.setMemberId(transaction.getMembers().getMemberId());
            details.setTransactionType(transaction.getTransactionType());
            details.setDueDate(transaction.getDueDate());
            details.setReturnDate(transaction.getReturnDate());

            transactionDetailsList.add(details);
        }

        return transactionDetailsList;
    }
    public List<TransactionDetails> getTransactionByMemberIdAndBookId(String memberId, String bookId) {
        List<Transactions> transactions = transactionRepo.findListByMembersMemberIdAndBookBookId(memberId,bookId);
        List<TransactionDetails> transactionDetailsList = new ArrayList<>();

        for (Transactions transaction : transactions) {
            TransactionDetails details = new TransactionDetails();
            details.setTransactionId(transaction.getTransactionId());
            details.setBookId(transaction.getBook().getBookId());
            details.setMemberId(transaction.getMembers().getMemberId());
            details.setTransactionType(transaction.getTransactionType());
            details.setDueDate(transaction.getDueDate());
            details.setReturnDate(transaction.getReturnDate());

            transactionDetailsList.add(details);
        }

        return transactionDetailsList;
    }


}
